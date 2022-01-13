package com.exercice.formation.services;

import com.exercice.formation.exception.CustomerAlreadyExistException;
import com.exercice.formation.models.Customer;
import com.exercice.formation.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer getByIdCustomer(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        return optionalCustomer.orElse(null);
//        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> getAllCustomer() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer createCustomer(Customer customer) throws CustomerAlreadyExistException {
        Optional<Customer> optionalUser = customerRepository.getUserByEmail(customer.getEmail());
        if (optionalUser.isPresent()) {
            throw new CustomerAlreadyExistException(customer.getEmail());
        }
        return customerRepository.save(new Customer(customer.getEmail(), customer.getLastname(), customer.getFirstname()));
    }

    public Customer getByEmailCustomer(String email, String lastname, String firstname) throws CustomerAlreadyExistException {
        Optional<Customer> optUser = customerRepository.getUserByEmail(email);
        if (!optUser.isPresent()) {
            Customer customer = new Customer(email, lastname, firstname);
            Customer customerDb = customerRepository.save(customer);
            return customerDb;
        } else {
            throw new CustomerAlreadyExistException("Customer at email: " + email + " already exist");
        }
    }
}
