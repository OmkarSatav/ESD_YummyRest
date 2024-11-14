package com.example.helloworld.service;

import com.example.helloworld.dto.CustomerRequest;
import com.example.helloworld.dto.ProductsRequest;
import com.example.helloworld.dto.ProductsResponse;
import com.example.helloworld.entity.Customer;
import com.example.helloworld.entity.Products;
import com.example.helloworld.helper.EncryptionService;
import com.example.helloworld.mapper.ProductsMapper;
import com.example.helloworld.repo.ProductsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductsService {

    // To store entity into sql database
    private final ProductsRepo repo;

    // To convert dto to entity
    private final ProductsMapper mapper;
    private final EncryptionService encryptionService;

    public Products addProduct(ProductsRequest request) {
        System.out.println("==================== create service");

        // This will convert our dto to entity using Mapper
        Products product = mapper.toEntity(request);
        repo.save(product);
        return product;
    }


    public ProductsResponse getProductById(Long id) {
        System.out.println("==================== fetch service");

        // Retrieve the product by its ID, or throw an exception if not found
        Products product = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
        return mapper.toDto(product);
    }
}