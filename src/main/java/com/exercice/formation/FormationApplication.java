package com.exercice.formation;

import com.exercice.formation.models.Invoice;
import com.exercice.formation.repositories.InvoiceRepository;
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
    public CommandLineRunner demo(InvoiceRepository invoiceRepository, InvoiceService invoiceService) {
        return (args -> {
            invoiceService.getInvoiceByPrice(25,"test");
            invoiceRepository.save(new Invoice(30,"test create invoice"));

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
