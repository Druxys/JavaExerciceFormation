package com.exercice.formation.services;

import com.exercice.formation.exception.InvoiceAlreadyExistException;
import com.exercice.formation.models.Customer;
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
        Customer customer = new Customer("test2@test2.test3", "popo", "polo");
        if (!optInvoice.isPresent()) {
            Invoice invoice = new Invoice(price, description, customer);
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
