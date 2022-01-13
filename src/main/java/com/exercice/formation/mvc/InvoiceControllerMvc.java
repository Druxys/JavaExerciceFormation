package com.exercice.formation.mvc;

import com.exercice.formation.models.Invoice;
import com.exercice.formation.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/mvc")
public class InvoiceControllerMvc {

    @Autowired
    InvoiceService invoiceService;

    @GetMapping(value = "/invoices")
    public String getInvoicesById(@RequestParam(name = "id", required = false) Long id, ModelMap modelMap) {
        List<Invoice> invoices = new ArrayList<Invoice>();
        if (id != null){
            Invoice invoice = invoiceService.getInvoiceById(id);
            invoices.add(invoice);
        }else{
            List<Invoice> list = invoiceService.getAllInvoice();
            invoices.addAll(list);
        }
        modelMap.addAttribute("invoices", invoices);
        return "invoice";
    }
}
