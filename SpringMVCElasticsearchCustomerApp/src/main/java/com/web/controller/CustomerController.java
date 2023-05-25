package com.web.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.model.Customer;
import com.web.repository.CustomerRepository;

@Controller
public class CustomerController {
	
	@Autowired
    private CustomerRepository erepo;

    @GetMapping("/")
    public String viewHomePage(Model model) throws IOException {
        model.addAttribute("listCustomerDocuments",erepo.searchAllDocuments());
        return "index";
    }

    @PostMapping("/saveCustomer")
    public String saveProduct(@ModelAttribute("customer") Customer customer) throws IOException {
        erepo.createOrUpdateDocument(customer);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{customerId}")
    public String showFormForUpdate(@PathVariable(value = "customerId") String customerId, Model model) throws IOException {

        Customer customer = erepo.getDocumentById(customerId);
        model.addAttribute("customer", customer);
        return "updateCustomerDocument";
    }

    @GetMapping("/showNewCustomerForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
    	Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "newCustomerDocument";
    }

    @GetMapping("/deleteCustomer/{customerId}")
    public String deleteCustomer(@PathVariable(value = "customerId") String customerId) throws IOException {

        this.erepo.deleteDocumentById(customerId);
        return "redirect:/";
    }
}
