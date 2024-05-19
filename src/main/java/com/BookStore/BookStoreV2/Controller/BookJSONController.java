package com.BookStore.BookStoreV2.Controller;

import com.BookStore.BookStoreV2.DTO.BookDTO;
import com.BookStore.BookStoreV2.Service.BookService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookJSONController {
    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public BookDTO addBook(@RequestBody BookDTO bookDTO) {
        return bookService.createBook(bookDTO);
    }

    @GetMapping("/getBook/{id}")
    public BookDTO getBook(@PathVariable long id) {
        return bookService.getBook(id);
    }
}
