package com.exercice.formation.controllers;

import com.exercice.formation.exception.CustomerAlreadyExistException;
import com.exercice.formation.models.Customer;
import com.exercice.formation.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<List<Customer>> getAll() {
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.getByIdCustomer(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> register(@RequestBody @Valid Customer customer) throws CustomerAlreadyExistException {

        Customer user = customerService.createCustomer(customer);
        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }
}
