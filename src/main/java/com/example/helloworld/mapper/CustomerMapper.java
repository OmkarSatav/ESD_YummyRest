package com.example.helloworld.mapper;

import com.example.helloworld.dto.CustomerRequest;
import com.example.helloworld.dto.CustomerResponse;
import com.example.helloworld.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    public Customer toEntity(CustomerRequest request) {
        return Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public CustomerResponse toDto(Customer customer) {
        return new CustomerResponse(
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail()
        );
    }
}