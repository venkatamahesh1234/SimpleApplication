package com.web.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	public List<Customer> companyId(Integer id);
}
