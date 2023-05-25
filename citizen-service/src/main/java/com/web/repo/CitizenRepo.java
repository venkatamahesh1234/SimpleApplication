package com.web.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.entity.Citizen;

public interface CitizenRepo extends JpaRepository<Citizen, Integer> {

	public List<Citizen> VaccinationCenterId(Integer id);
}
