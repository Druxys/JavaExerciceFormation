package com.exercice.formation.controllers;

import com.exercice.formation.models.Invoice;
import com.exercice.formation.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/")
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        return new ResponseEntity<List<Invoice>>(invoiceService.getAllInvoice(), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id){
        return new ResponseEntity<Invoice>(invoiceService.getInvoiceById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Invoice> create(@RequestBody @Valid Invoice invoice){
        return new ResponseEntity<Invoice>(invoiceService.getInvoiceByPrice(invoice.getPrice(), invoice.getDescription()), HttpStatus.OK);
    }
}
