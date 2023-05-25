package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.entity.Customer;
import com.web.repo.CustomerRepo;

@RestController
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerRepo repo;

	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("Hello", HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Customer> addCitizen(@RequestBody Customer newCustomer) {
		repo.save(newCustomer);
		return new ResponseEntity<>(newCustomer, HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<List<Customer>> getById(@PathVariable int id) {
		List<Customer> listCustomer = repo.companyId(id);
		return new ResponseEntity<>(listCustomer, HttpStatus.OK);
	}

}
