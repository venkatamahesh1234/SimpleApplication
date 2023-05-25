package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.entity.Product;
import com.web.repo.ProductRepo;


@RestController
public class ProductController {
	@Autowired
	private ProductRepo repo;

	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("Hello", HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Product> addCitizen(@RequestBody Product newProduct) {
		repo.save(newProduct);
		return new ResponseEntity<>(newProduct, HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<List<Product>> getById(@PathVariable int id) {
		List<Product> listCustomer = repo.bankId(id);
		return new ResponseEntity<>(listCustomer, HttpStatus.OK);
	}

}
