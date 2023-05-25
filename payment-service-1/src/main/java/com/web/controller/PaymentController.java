package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.common.RequiredResponse;
import com.web.entity.Payment;
import com.web.repo.PaymentRepo;

@RestController
@RequestMapping("payment")
public class PaymentController {
	@Autowired
	private PaymentRepo repo;
	
	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("Hello", HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Payment> addCitizen(@RequestBody Payment newPayment) {
		repo.save(newPayment);
		return new ResponseEntity<>(newPayment, HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<RequiredResponse> getAllDatabaseonCenterId(@PathVariable Integer id) {
		RequiredResponse requiredResponse = new RequiredResponse();
		// 1st Get Vaccination Center Details
		Product product = repo.findById(id).get();
		requiredResponse.setCenter(product);

		/*// Then Get citizen registered to Vaccination Details
		List<Citizen> listOfCitizens = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/" + id, List.class);
		requiredResponse.setCitizens(listOfCitizens);
		return new ResponseEntity<RequiredResponse>(requiredResponse, HttpStatus.OK);*/
	}


}
