package com.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.entity.Product;
import java.util.List;


public interface ProductRepo extends JpaRepository<Product, Integer> {
	public List<Product> bankIdId(Integer id);
}
