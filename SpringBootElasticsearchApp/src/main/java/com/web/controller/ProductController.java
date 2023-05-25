package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Product;
import com.web.service.ProductService;

@RestController
@RequestMapping("/apis")
public class ProductController {
	
	@Autowired
	private ProductService pservice;
	
	@GetMapping("/getAllDoc")
	Iterable<Product> getAllDoc() {
		return pservice.getProducts();
	}
	
	@GetMapping("/getOneDoc/{id}")
	public Product getOneDoc(@PathVariable int id) {
		return pservice.getOneProduct(id);
	}
	
	@PostMapping("/insertDoc")
	public Product insertDoc(@RequestBody Product product) {
		return pservice.insertProducts(product);
	}
	
	@DeleteMapping("/deleteDoc/{id}")
	public void deleteDoc(@PathVariable int id) {
		pservice.deleteProducts(id);
	}
	
	@PutMapping("/updateDoc/{id}")
	public Product updateDoc(@RequestBody Product product,@PathVariable int id) {
		return pservice.updateProducts(product, id);
	}
}
