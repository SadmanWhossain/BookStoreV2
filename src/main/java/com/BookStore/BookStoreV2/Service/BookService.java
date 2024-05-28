package com.BookStore.BookStoreV2.Service;

import com.BookStore.BookStoreV2.DTO.BookDTO;
import com.BookStore.BookStoreV2.Entity.AuthorEntity;
import com.BookStore.BookStoreV2.Entity.BookEntity;
import com.BookStore.BookStoreV2.Exceptions.RecordNotFound;
import com.BookStore.BookStoreV2.Repository.AuthorRepository;
import com.BookStore.BookStoreV2.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    public BookDTO createBook(BookDTO bookDTO) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(bookDTO.getTitle());
        bookEntity.setPrice(bookDTO.getPrice());
        AuthorEntity authorEntity;
        Optional<AuthorEntity> authorEntityOptional = authorRepository.findByName(bookDTO.getAuthor()).stream().findFirst();
        if (authorEntityOptional.isPresent()) {
            authorEntity = authorEntityOptional.get();
            bookEntity.setAuthorEntity(authorEntity);
            List<BookEntity> books = new ArrayList<>(authorEntity.getBooks());
            books.add(bookEntity);
            authorEntity.setBooks(books);
        } else {
            authorEntity = new AuthorEntity();
            authorEntity.setName(bookDTO.getAuthor());
            bookEntity.setAuthorEntity(authorEntity);
            authorEntity.setBooks(List.of(bookEntity));
        }
        authorRepository.save(authorEntity);
        bookRepository.save(bookEntity);
        return bookDTO;
    }

    public BookDTO getBook(long id) {
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow(() -> new RecordNotFound("Book not found with ID: " + id));
        return new BookDTO(bookEntity.getId(), bookEntity.getTitle(), bookEntity.getPrice(), bookEntity.getAuthorEntity().getName());
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private BookDTO convertToDTO(BookEntity bookEntity) {
        return new BookDTO(
                bookEntity.getId(),
                bookEntity.getTitle(),
                bookEntity.getPrice(),
                bookEntity.getAuthorEntity().getName()
        );
    }

}
