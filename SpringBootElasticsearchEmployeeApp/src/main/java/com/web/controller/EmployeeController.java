package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Employee;
import com.web.service.EmployeeService;

@RestController
@RequestMapping("empDtls")
public class EmployeeController {

	@Autowired
	private EmployeeService eservice;

	@PostMapping("/insertDoc")
	public Employee insertDoc(@RequestBody Employee emp) {
		return eservice.insertEmployees(emp);
	}

	@GetMapping("/getAllDoc")
	Iterable<Employee> getAllDoc() {
		return eservice.getAllEmployees();
	}

	@GetMapping("/getOneDoc/{empNo}")
	public Employee getOneDoc(@PathVariable int empNo) {
		return eservice.getOneEmployee(empNo);
	}

	@PutMapping("/updateDoc/{empNo}")
	public Employee updateDoc(@RequestBody Employee emp, @PathVariable int empNo) {
		return eservice.updateEmployee(emp, empNo);
	}

	@DeleteMapping("/deleteDoc/{empNo}")
	public void deleteDoc(@PathVariable int empNo) {
		eservice.deleteEmployee(empNo);

	}
}
