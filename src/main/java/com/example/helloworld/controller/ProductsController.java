package com.example.helloworld.controller;

import com.example.helloworld.dto.ProductsRequest;
import com.example.helloworld.dto.ProductsResponse;
import com.example.helloworld.entity.Products;
import com.example.helloworld.service.ProductsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

    // final : it will create only one object in whole project container, when we run the project
    private final ProductsService productsService;

    @PostMapping // for post request
    public ResponseEntity<Products> addProduct(@RequestBody @Valid ProductsRequest request) {
        System.out.println("==================== create controller");
        return ResponseEntity.ok(productsService.addProduct(request));
    }

    @GetMapping("/{id}") // for get request to fetch a product by its ID
    public ResponseEntity<ProductsResponse> getProductById(@PathVariable("id") Long id) {
        System.out.println("==================== fetch controller");
        return ResponseEntity.ok(productsService.getProductById(id));
    }
}