package com.example.bankapp.controller;

import com.example.bankapp.model.Customer;
import com.example.bankapp.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    CustomerRepository customerRepository;

    public LoginController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){
        ResponseEntity response;

        try{
            customerRepository.save(customer);
            response = ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        }catch (Exception ex){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Exception occured" + ex.getMessage());
        }
        return response;
    }
}
