package com.example.helloworld.mapper;

import com.example.helloworld.dto.ProductsRequest;
import com.example.helloworld.entity.Products;
import org.springframework.stereotype.Service;

@Service
public class ProductsMapper {
    public Products toEntity(ProductsRequest request) {
        return Products.builder()
                .productName(request.product_name())
                .price(request.price())
                .build();
    }
}