package com.exercice.formation;

import com.exercice.formation.models.Customer;
import com.exercice.formation.models.Invoice;
import com.exercice.formation.models.invoice.TypeTVA;
import com.exercice.formation.repositories.CustomerRepository;
import com.exercice.formation.repositories.InvoiceRepository;
import com.exercice.formation.services.CustomerService;
import com.exercice.formation.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class FormationApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormationApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(InvoiceRepository invoiceRepository, InvoiceService invoiceService, CustomerRepository customerRepository, CustomerService customerService) {
        return (args -> {
//            invoiceService.getInvoiceByPrice(52,"test655");
            customerService.getByIdCustomer(5L);
            Customer saveCustomer = customerRepository.save(new Customer("test@test.testo", "popo", "pol"));

            invoiceRepository.save(new Invoice(40,"test create invoice",saveCustomer, TypeTVA.NORMAL, TypeTVA.NORMAL.getSomme(), 8, 48));

            for (Invoice invoice: invoiceRepository.findAll()) {
                System.out.println(invoice.toString());
            }
            System.out.println("");

            Optional<Invoice> price = invoiceRepository.getInvoiceByPrice(30);
            if (price.isPresent()) {
                Invoice priceDb = price.get();
                System.out.println(priceDb.toString());
                System.out.println("");
            }


        });
    }

}
