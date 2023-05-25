package com.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.entity.VaccinationCenter;

@Repository
public interface VaccinationCenterRepo extends JpaRepository<VaccinationCenter, Integer> {

}
