package com.example.helloworld.service;

import com.example.helloworld.dto.ProductsRequest;
import com.example.helloworld.entity.Products;
import com.example.helloworld.mapper.ProductsMapper;
import com.example.helloworld.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class  ProductsService {

    private final ProductRepository productRepository;

    private final ProductsMapper productMapper;


    public String addProduct(ProductsRequest product) {
        Products product1 = productMapper.toEntity(product);
        productRepository.save(product1);
        return "Product added";
    }

    // Read product by ID
    public Products getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Read product by name
    public Products getProductByName(String productName) {
        return productRepository.findProductsByProductName(productName);
    }

    // Read all products
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public Products updateProduct(Long id, Products updatedProduct) {
        Products existingProduct = getProductById(id);
        if (existingProduct != null) {
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setPrice(updatedProduct.getPrice());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public String getProductsWithPriceRange(String low, String high) {
        List<Products> products = productRepository.fetchTopProductByPrice(low,high);
        StringBuilder pro = new StringBuilder();
        for(Products product : products) {
            pro.append(product.getId() + " " + product.getProductName() + " " + product.getPrice()).append(",\n");
        }
        return pro.toString();
    }

}