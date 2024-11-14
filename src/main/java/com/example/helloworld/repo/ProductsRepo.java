package com.example.helloworld.repo;

import com.example.helloworld.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ProductsRepo extends JpaRepository<Products, Long> {
    Optional<Products> findById(Long Id);
}