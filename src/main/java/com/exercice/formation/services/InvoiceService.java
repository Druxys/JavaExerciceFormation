package com.exercice.formation.services;

import com.exercice.formation.models.Invoice;
import com.exercice.formation.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findInvoiceById(id);
    }

    public List<Invoice> getAllInvoice(){
        return invoiceRepository.findAll();
    }
}
