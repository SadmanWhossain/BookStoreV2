package com.BookStore.BookStoreV2.Exceptions;

import lombok.Data;

@Data
public class ErrorObject {
    private String message;
    private String statusCode;
}
