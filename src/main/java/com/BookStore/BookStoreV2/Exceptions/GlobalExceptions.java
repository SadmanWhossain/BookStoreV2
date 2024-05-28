package com.BookStore.BookStoreV2.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptions {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorObject> handleRuntimeException(RuntimeException e) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setMessage(e.getMessage());
        errorObject.setStatusCode("C500");
        return ResponseEntity.status(500).body(errorObject);
    }

    @ExceptionHandler(RecordNotFound.class)
    public ResponseEntity<ErrorObject> handleRecordNotFound(RecordNotFound e) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setMessage(e.getMessage());
        errorObject.setStatusCode("C404");
        return ResponseEntity.status(404).body(errorObject);
    }
}
