package com.BookStore.BookStoreV2.Controller;

import com.BookStore.BookStoreV2.DTO.AuthorDTO;
import com.BookStore.BookStoreV2.DTO.BookDTO;
import com.BookStore.BookStoreV2.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/bookList")
    public String bookList(Model model) {
        model.addAttribute("BookList", bookService.getAllBooks());
        return "bookList";
    }

    @GetMapping("/book/{id}")
    public String getBookById(Model model,@PathVariable long id){
        model.addAttribute("book",bookService.getBook(id));
        return "book";
    }

    @GetMapping("/bookEntry")
    public String bookEntry(Model model){
        model.addAttribute("book", new BookDTO());
        model.addAttribute("author", new AuthorDTO());
        return "registerBook";
    }

    @PostMapping("/account")
    public String account(@ModelAttribute BookDTO bookDTO, @ModelAttribute AuthorDTO authorDTO){
        bookService.createBook(bookDTO);

        return "redirect:/bookList";
    }
}
