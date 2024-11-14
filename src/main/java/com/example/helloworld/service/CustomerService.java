package com.example.helloworld.service;

import lombok.RequiredArgsConstructor;
import com.example.helloworld.dto.CustomerRequest;
import com.example.helloworld.dto.CustomerResponse;
import com.example.helloworld.entity.Customer;
import com.example.helloworld.mapper.CustomerMapper;
import com.example.helloworld.repo.CustomerRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final CustomerRepo repo;
    private final CustomerMapper mapper;

    public String createCustomer(CustomerRequest request) {
        Customer customer = mapper.toEntity(request);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        repo.save(customer);
        return "Customer Created";
    }

    public List<CustomerResponse> getAllCustomers(){
        List<Customer> allCustomers = repo.findAll();
        return allCustomers.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

}