package com.exercice.formation.services;

import com.exercice.formation.exception.InvoiceAlreadyExistException;
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

    public Invoice getInvoiceByPrice(double price, String description) throws InvoiceAlreadyExistException{
        Optional<Invoice> optInvoice = invoiceRepository.getInvoiceByPrice(price);
        if (!optInvoice.isPresent()) {
            Invoice invoice = new Invoice(price, description);
            return invoiceRepository.save(invoice);
        }else {
            throw new InvoiceAlreadyExistException("Invoice at description : " + description + " already exist");
        }
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findInvoiceById(id);
    }

    public List<Invoice> getAllInvoice(){
        return invoiceRepository.findAll();
    }
}
