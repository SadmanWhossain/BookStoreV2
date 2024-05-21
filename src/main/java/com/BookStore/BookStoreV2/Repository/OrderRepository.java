package com.BookStore.BookStoreV2.Repository;

import com.BookStore.BookStoreV2.Entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
