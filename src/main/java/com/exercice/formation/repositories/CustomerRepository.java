package com.exercice.formation.repositories;

import com.exercice.formation.models.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long>{
}
