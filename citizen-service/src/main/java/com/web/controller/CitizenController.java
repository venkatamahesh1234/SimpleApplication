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

import com.web.entity.Citizen;
import com.web.repo.CitizenRepo;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	@Autowired
	private CitizenRepo repo;

	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return new ResponseEntity<>("Hello", HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen newCitizen) {
		repo.save(newCitizen);
		return new ResponseEntity<>(newCitizen, HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<List<Citizen>> getById(@PathVariable int id) {
		List<Citizen> listCitizen = repo.VaccinationCenterId(id);
		return new ResponseEntity<>(listCitizen, HttpStatus.OK);
	}

}
