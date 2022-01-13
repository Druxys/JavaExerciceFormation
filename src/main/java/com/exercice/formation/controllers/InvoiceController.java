package com.exercice.formation.controllers;

import com.exercice.formation.models.Invoice;
import com.exercice.formation.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;

    @GetMapping("/invoices")
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        return new ResponseEntity<List<Invoice>>(invoiceService.getAllInvoice(), HttpStatus.OK);
    }

    @GetMapping("/invoice/id")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id){
        return new ResponseEntity<Invoice>(invoiceService.getInvoiceById(id), HttpStatus.OK);
    }

    @PostMapping("/invoice")
    public ResponseEntity<Invoice> create(@RequestBody @Valid Invoice invoice){
        return new ResponseEntity<Invoice>(invoiceService.getInvoiceById(invoice.getId()), HttpStatus.OK);
    }
}
