package com.BookStore.BookStoreV2.Repository;

import com.BookStore.BookStoreV2.Entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
