package com.exercice.formation.services;

import com.exercice.formation.models.Invoice;
import com.exercice.formation.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    public Invoice getInvoiceByPrice(double price, String description){
        Optional<Invoice> optInvoice = invoiceRepository.getInvoiceByPrice(price);
            Invoice invoice = new Invoice(price, description);
            return invoiceRepository.save(invoice);
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findInvoiceById(id);
    }

    public List<Invoice> getAllInvoice(){
        return invoiceRepository.findAll();
    }
}
