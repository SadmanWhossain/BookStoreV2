package com.BookStore.BookStoreV2.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AddressDTO {
    private int id;
    private String street;
    private String city;
    private String zip;
}
