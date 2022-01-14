package com.exercice.formation.services;

import com.exercice.formation.exception.InvoiceAlreadyExistException;
import com.exercice.formation.models.Customer;
import com.exercice.formation.models.Invoice;
import com.exercice.formation.models.invoice.TypeTVA;
import com.exercice.formation.repositories.CustomerRepository;
import com.exercice.formation.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    CustomerRepository customerRepository;

    public Invoice getInvoiceByPrice(double price, String description, TypeTVA tva) throws InvoiceAlreadyExistException{
        Optional<Invoice> optInvoice = invoiceRepository.getInvoiceByPrice(price);
        Customer customer = new Customer("test@test.testosterone", "popolou", "polopopo");
        Customer customerDb = customerRepository.save(customer);
        if (!optInvoice.isPresent()) {
            double tvaPrice = (price * tva.getSomme()) / 100 ;
            double total = price + tvaPrice;

            Invoice invoice = new Invoice(price, description, customerDb, tva, tva.getSomme(), tvaPrice, total);
            invoice.setTvaPrice(tvaPrice);
            invoice.setTva2(tva.getSomme());
            Invoice invoiceResult = invoiceRepository.save(invoice);
            return invoiceResult;
        }else {
            throw new InvoiceAlreadyExistException("Invoice at description : " + description + " already exist");
        }
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findInvoiceById(id);
    }

    public List<Invoice> getAllInvoice(){
        return (List<Invoice>) invoiceRepository.findAll();
    }
}
