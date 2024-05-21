package com.BookStore.BookStoreV2.Controller;

import com.BookStore.BookStoreV2.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customerList")
    public String customerList(Model model) {
        model.addAttribute("CustomerList", customerService.getAllCustomers());
        return "customerList";
    }
}
