package com.example.products.api.exceptions;


public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(int id) {
        super(String.valueOf(id));
    }
}
