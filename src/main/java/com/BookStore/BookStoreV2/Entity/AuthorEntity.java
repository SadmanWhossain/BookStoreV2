package com.BookStore.BookStoreV2.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;

    @OneToMany(mappedBy = "authorEntity",cascade = CascadeType.ALL)
    List<BookEntity> books;
}
