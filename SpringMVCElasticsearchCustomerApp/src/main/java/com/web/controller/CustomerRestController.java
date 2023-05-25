package com.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Customer;
import com.web.repository.CustomerRepository;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerRepository erepo;
	
	 @PostMapping("/createOrUpdateDocument")
	    public ResponseEntity<Object> createProduct(@RequestBody Customer customer) throws IOException {
	          String response = erepo.createOrUpdateDocument(customer);
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	    @GetMapping("/getDocument")
	    public ResponseEntity<Object> getDocumentById(@RequestParam String customerId) throws IOException {
	       Customer customer =  erepo.getDocumentById(customerId);
	        return new ResponseEntity<>(customer, HttpStatus.OK);
	    }

	    @DeleteMapping("/deleteDocument")
	    public ResponseEntity<Object> deleteDocumentById(@RequestParam String customerId) throws IOException {
	        String response =  erepo.deleteDocumentById(customerId);
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	    @GetMapping("/searchDocument")
	    public ResponseEntity<Object> searchAllDocument() throws IOException {
	        List<Customer> customers = erepo.searchAllDocuments();
	        return new ResponseEntity<>(customers, HttpStatus.OK);
	    }
}
