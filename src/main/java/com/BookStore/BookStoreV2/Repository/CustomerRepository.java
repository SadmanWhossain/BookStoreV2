package com.BookStore.BookStoreV2.Repository;

import com.BookStore.BookStoreV2.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
