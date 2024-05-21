package com.BookStore.BookStoreV2.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CustomerDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private List<AddressDTO> addresses;
}
