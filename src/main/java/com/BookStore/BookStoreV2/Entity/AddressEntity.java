package com.BookStore.BookStoreV2.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String street;
    private String city;
    private String zip;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;
}
