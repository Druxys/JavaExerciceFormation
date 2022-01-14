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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    CustomerRepository customerRepository;

    public Invoice getInvoiceByPrice(double price, String description, TypeTVA tva, Customer customer) throws InvoiceAlreadyExistException{
        Optional<Invoice> optInvoice = invoiceRepository.getInvoiceByPrice(price);
        Customer customerdb = new Customer("test@test.testosterone", "popolou", "polopopo");
        Customer customerDb2 = customerRepository.save(customerdb);
        if (!optInvoice.isPresent()) {
            double tvaPrice = (price * tva.getSomme()) / 100 ;
            double total = price + tvaPrice;
            LocalDate date = LocalDate.now();

            Invoice invoice = new Invoice(price, description, customer, tva, tva.getSomme(), tvaPrice, total, date);
            invoice.setTvaPrice(tvaPrice);
            invoice.setTva2(tva.getSomme());
            return invoiceRepository.save(invoice);
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
