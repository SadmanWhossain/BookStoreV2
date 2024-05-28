package com.BookStore.BookStoreV2.Controller;

import com.BookStore.BookStoreV2.DTO.AddressDTO;
import com.BookStore.BookStoreV2.DTO.CustomerDTO;
import com.BookStore.BookStoreV2.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customerList")
    public String customerList(Model model) {
        model.addAttribute("CustomerList", customerService.getAllCustomers());
        return "customerList";
    }

    @GetMapping("/registerCustomer")
    public String registerCustomer(Model model){
        model.addAttribute("customer",new CustomerDTO());
        model.addAttribute("address", new AddressDTO());
        return "registerCustomer";
    }

    @PostMapping("/register")
    public String addCustomer(@ModelAttribute CustomerDTO customerDTO, @ModelAttribute AddressDTO addressDTO){
        customerDTO.setAddresses(List.of(addressDTO));
        customerService.addCustomer(customerDTO);
        return "redirect:/bookList";
    }

}
