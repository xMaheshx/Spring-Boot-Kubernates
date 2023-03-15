package com.example.products.api.model;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

    @NotEmpty
    private int id;

    @NotBlank
    @Size(min = 1, max = 30)
    private String name;

    private double price;
}
