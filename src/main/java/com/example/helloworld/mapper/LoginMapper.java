package com.example.helloworld.mapper;

import com.example.helloworld.dto.LoginRequest;
import com.example.helloworld.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class LoginMapper {
    public Customer toEntity(LoginRequest request) {
        return Customer.builder()
                .email(request.email())
                .password(request.password())
                .build();
    }
}