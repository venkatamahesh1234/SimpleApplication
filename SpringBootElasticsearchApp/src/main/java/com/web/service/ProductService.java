package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.Product;
import com.web.repository.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	public Iterable<Product> getProducts(){
		return productRepo.findAll();
	}
	
	public Product insertProducts(Product product){
		return productRepo.save(product);
	}
	
	public Product updateProducts(Product product,int id){
		Product p1= productRepo.findById(id).get();
		p1.setId(id);
		p1.setPrice(product.getPrice());
		return productRepo.save(p1);
	}
	public void deleteProducts(int id){
		productRepo.deleteById(id);
	}
	
	public Product getOneProduct(int id) {
		return productRepo.findById(id).get();
	}
}
