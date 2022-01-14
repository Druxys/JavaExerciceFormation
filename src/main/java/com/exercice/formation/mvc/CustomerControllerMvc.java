package com.exercice.formation.mvc;

import com.exercice.formation.models.Customer;
import com.exercice.formation.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/mvc")
public class CustomerControllerMvc {
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = {"/createCustomer"}, method = RequestMethod.GET)
    public String showAddCustomer(Model model) {

        Customer customerForm = new Customer();
        model.addAttribute("customer", customerForm);

        return "createCustomer";
    }

    @RequestMapping(value = {"/createCustomer"}, method = RequestMethod.POST)
    public String createCustomer(Model model, @ModelAttribute("customer") Customer customerForm) {
        return "createCustomer";
    }

}
