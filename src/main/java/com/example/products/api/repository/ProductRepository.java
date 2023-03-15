package com.example.products.api.repository;

import com.example.products.api.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Repository
public class ProductRepository {
    private final Map<Integer, Product> products = Map.of(
            1, Product.builder().id(1).name("iPhone 14").price(899.00).build(),
            2, Product.builder().id(2).name("PS5").price(599.00).build(),
            3, Product.builder().id(3).name("MacBook Pro M2").price(2999.00).build());


    public Collection<Product> findAll() {
        return products.values();
    }

    public Optional<Product> findById(int id) {
        return Optional.ofNullable(products.get(id));
    }
}
