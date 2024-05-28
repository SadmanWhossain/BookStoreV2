package com.BookStore.BookStoreV2.Exceptions;

public class RecordNotFound extends RuntimeException{
    public RecordNotFound(String s){
        super(s);
    }
}
