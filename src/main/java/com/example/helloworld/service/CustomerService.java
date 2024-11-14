package com.example.helloworld.service;

import java.util.Optional;

import com.example.helloworld.dto.CustomerRequest;
import com.example.helloworld.dto.CustomerResponse;
import com.example.helloworld.entity.Customer;
import com.example.helloworld.mapper.CustomerMapper;
import com.example.helloworld.repo.CustomerRepo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.helloworld.helper.EncryptionService;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class CustomerService {

    // To store entity into sql database
    private final CustomerRepo repo;

    // To convert dto to entity
    private final CustomerMapper mapper;

    private final EncryptionService encryptionService;

    public Customer createCustomer(CustomerRequest request) {
        System.out.println("==================== create service");

        // This will convert our dto to entity using Mapper
        Customer customer = mapper.toEntity(request);
        customer.setPassword(encryptionService.encode(customer.getPassword()));
        // Stores entity into database using Repo
        repo.save(customer);
        return customer;
    }
}