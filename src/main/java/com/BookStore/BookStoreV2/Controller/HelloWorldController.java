package com.BookStore.BookStoreV2.Controller;

import com.BookStore.BookStoreV2.DTO.BookDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloWorldController {
    @GetMapping("/helloWorld")
    public String helloWorld(Model model) {
        List<BookDTO> bookDTOList = List.of(
                new BookDTO("himu","100","humayun"),
                new BookDTO("bimu","1000","bumayun")
        );

        model.addAttribute("bookDTOList", bookDTOList);
        return "HelloWorld";
    }
}
