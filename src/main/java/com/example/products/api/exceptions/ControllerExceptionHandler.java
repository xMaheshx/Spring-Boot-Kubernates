package com.example.products.api.exceptions;

import com.example.products.api.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Error> handleProductNotFound(RuntimeException ex) {
        return new ResponseEntity<>(
                Error.builder().code(HttpStatus.NOT_FOUND.name()).message("Product Not Found : " + ex.getMessage()).build(),
                HttpStatus.NOT_FOUND);
    }
}
