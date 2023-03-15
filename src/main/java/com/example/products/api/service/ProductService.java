package com.example.products.api.service;

import com.example.products.api.exceptions.ProductNotFoundException;
import com.example.products.api.model.Product;
import com.example.products.api.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository repository;

    public Product findById(int id) {
        return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    public Collection<Product> findAll() {
        return repository.findAll();
    }

}