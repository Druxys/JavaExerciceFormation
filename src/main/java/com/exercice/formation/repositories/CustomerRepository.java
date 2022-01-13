package com.exercice.formation.repositories;

import com.exercice.formation.models.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
    Optional<Customer> getUserByEmail(String email);
}
