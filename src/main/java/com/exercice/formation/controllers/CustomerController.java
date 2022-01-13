package com.exercice.formation.controllers;

import com.exercice.formation.models.Customer;
import com.exercice.formation.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<List<Customer>> getAll(){
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }
}
