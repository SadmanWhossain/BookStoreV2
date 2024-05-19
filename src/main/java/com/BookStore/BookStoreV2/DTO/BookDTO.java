package com.BookStore.BookStoreV2.DTO;

import com.BookStore.BookStoreV2.Entity.AuthorEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookDTO {
    private String title;
    private String price;
    private String author;

    @Override
    public String toString() {
        return "BookDTO{" +
                "title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
