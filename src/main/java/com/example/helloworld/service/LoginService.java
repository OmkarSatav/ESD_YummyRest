package com.example.helloworld.service;
import java.util.Optional;

import com.example.helloworld.dto.LoginRequest;
import com.example.helloworld.entity.Customer;
import com.example.helloworld.mapper.LoginMapper;
import com.example.helloworld.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.helloworld.helper.EncryptionService;
import com.example.helloworld.helper.JWTHelper;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final CustomerRepo repo;
    private final LoginMapper mapper;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;

    public String loginUser(LoginRequest request) {
        Customer customer = mapper.toEntity(request);
        Optional<Customer> existingCustomer = repo.findByEmail(customer.getEmail());

        if (existingCustomer.isPresent()) {
            if(!encryptionService.validates(request.password(), existingCustomer.get().getPassword())) {
                return "Wrong Password or Email";
            }
            else {
                return jwtHelper.generateToken(request.email());
            }
        } else {
            return "User not found";
        }
    }
}