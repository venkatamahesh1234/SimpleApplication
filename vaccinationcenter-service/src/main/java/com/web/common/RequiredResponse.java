package com.web.common;

import java.util.List;

import com.web.entity.VaccinationCenter;

public class RequiredResponse {
	private VaccinationCenter center;
	private List<Citizen> citizens;
	public RequiredResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VaccinationCenter getCenter() {
		return center;
	}
	public void setCenter(VaccinationCenter center) {
		this.center = center;
	}
	public List<Citizen> getCitizens() {
		return citizens;
	}
	public void setCitizens(List<Citizen> citizens) {
		this.citizens = citizens;
	}

}