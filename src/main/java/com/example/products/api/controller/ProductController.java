package com.example.products.api.controller;

import com.example.products.api.model.Product;
import com.example.products.api.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@AllArgsConstructor
@Slf4j
public class ProductController {


    private ProductService productService;

    @GetMapping("/products")
    @Operation(summary = "Gets All Products")
    public Collection<Product> getProducts() {
        log.info("GET: All Products");
        return productService.findAll();
    }

    @GetMapping(value = "/product/{id}")
    @Operation(summary = "Gets Product by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Product.class))}),
            @ApiResponse(responseCode = "404", description = "Product not found")})
    public Product getProducts(@Parameter(description = "Id of product to be searched") @PathVariable("id") int id) {
        log.info("GET: Product {}", id);
        return productService.findById(id);
    }


    @PutMapping("/product/{id}")
    @Operation(summary = "Updates a given Product")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(@Parameter(description = "Id of product to be updated") @PathVariable("id") final String id, @RequestBody final Product product) {
        log.info("UPDATE: Product {}", id);
        return product;
    }

    @PatchMapping("/product/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Patches a given Product")
    public Product patchProduct(@Parameter(description = "Id of product to be patched") @PathVariable("id") final String id, @RequestBody final Product product) {
        log.info("PATCH: Product {}", id);
        return product;
    }

    @PostMapping("/product/")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Creates a given Product")
    public Product postProduct(@NotNull @Valid @RequestBody final Product product) {
        log.info("POST: Product {}", product);
        return product;
    }

    @DeleteMapping("/product/{id}")
    @Operation(summary = "Deletes a given Product")
    @ResponseStatus(HttpStatus.OK)
    public long deleteProduct(@Parameter(description = "Id of product to be deleted") @PathVariable final long id) {
        log.info("DELETE: Product {}", id);
        return id;
    }
}
