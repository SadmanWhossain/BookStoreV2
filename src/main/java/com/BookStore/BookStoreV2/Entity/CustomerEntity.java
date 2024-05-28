package com.BookStore.BookStoreV2.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "customerEntity")
    private List<AddressEntity> addresses;

    @OneToMany(mappedBy = "customerEntity")
    private List<OrderEntity> orderEntities;
}
