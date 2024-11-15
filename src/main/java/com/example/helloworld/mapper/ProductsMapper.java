package com.example.helloworld.mapper;

import com.example.helloworld.dto.CustomerRequest;
import com.example.helloworld.dto.ProductsRequest;
import com.example.helloworld.dto.ProductsResponse;
import com.example.helloworld.entity.Products;
import org.springframework.stereotype.Service;

@Service
public class ProductsMapper {
    public Products toEntity(ProductsRequest request) {
        return Products.builder()
                .productName(request.productName())
                .price(request.price())
                .build();
    }


    public ProductsResponse toDto(Products product) {
        ProductsResponse response = new ProductsResponse(
                product.getId(), product.getProductName(), product.getPrice()
        );
        // Map other fields as needed
        return response;
    }
}