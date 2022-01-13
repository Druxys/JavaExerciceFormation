package com.exercice.formation.repositories;

import com.exercice.formation.models.Invoice;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long>{
    Invoice findInvoiceById(Long id);
    List<Invoice> findAll();
}
