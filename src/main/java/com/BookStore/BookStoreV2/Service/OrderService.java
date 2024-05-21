package com.BookStore.BookStoreV2.Service;

import com.BookStore.BookStoreV2.Entity.BookEntity;
import com.BookStore.BookStoreV2.Entity.OrderEntity;
import com.BookStore.BookStoreV2.Repository.BookRepository;
import com.BookStore.BookStoreV2.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    BookRepository bookRepository;

    @Transactional
    public void addBookToOrder(Long orderId, Long bookId) {
        OrderEntity order = orderRepository.findById(orderId).orElseThrow();
        BookEntity book = bookRepository.findById(bookId).orElseThrow();
        order.getBooks().add(book);
        book.getOrders().add(order);
    }
}
