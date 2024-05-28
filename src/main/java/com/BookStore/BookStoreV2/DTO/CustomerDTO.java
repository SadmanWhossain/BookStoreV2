package com.BookStore.BookStoreV2.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private List<AddressDTO> addresses;

    public CustomerDTO() {
    }

    public CustomerDTO(long id, String firstName, String lastName, String email, String phone, List<AddressDTO> addresses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.addresses = addresses;
    }
}
