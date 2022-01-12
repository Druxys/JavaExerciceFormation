package com.exercice.formation.repositories;

import com.exercice.formation.models.Invoice;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long>{
}
