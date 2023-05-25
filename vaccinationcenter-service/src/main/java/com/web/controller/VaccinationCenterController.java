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
import org.springframework.web.client.RestTemplate;

import com.web.common.Citizen;
import com.web.common.RequiredResponse;
import com.web.entity.VaccinationCenter;
import com.web.repo.VaccinationCenterRepo;

@RestController
@RequestMapping("/vaccinationCenter")
public class VaccinationCenterController {
	@Autowired
	private VaccinationCenterRepo centerRepo;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/add")
	public ResponseEntity<VaccinationCenter> addCenter(@RequestBody VaccinationCenter newCenter) {
		VaccinationCenter center = centerRepo.save(newCenter);
		return new ResponseEntity<>(center, HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<RequiredResponse> getAllDatabaseonCenterId(@PathVariable Integer id) {
		RequiredResponse requiredResponse = new RequiredResponse();
		// 1st Get Vaccination Center Details
		VaccinationCenter center = centerRepo.findById(id).get();
		requiredResponse.setCenter(center);

		// Then Get citizen registered to Vaccination Details
		List<Citizen> listOfCitizens = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/" + id, List.class);
		requiredResponse.setCitizens(listOfCitizens);
		return new ResponseEntity<RequiredResponse>(requiredResponse, HttpStatus.OK);
	}

}
