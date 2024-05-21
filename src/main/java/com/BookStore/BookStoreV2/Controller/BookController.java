package com.BookStore.BookStoreV2.Controller;

import com.BookStore.BookStoreV2.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/bookList")
    public String bookList(Model model) {
        model.addAttribute("BookList", bookService.getAllBooks());
        return "bookList";
    }
}
