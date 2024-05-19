package com.BookStore.BookStoreV2.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String price;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AuthorEntity authorEntity;
}
