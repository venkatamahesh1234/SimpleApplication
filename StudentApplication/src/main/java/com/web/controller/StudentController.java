package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.model.Student;
import com.web.service.StudentService;

@RestController
@CrossOrigin("*")
@RequestMapping("/studentData")
public class StudentController {
	@Autowired
	private StudentService service;

	@PostMapping("/add")
	public Student add(@RequestBody Student std) {
		return service.insertStd(std);
	}

	@GetMapping("/getAll")
	public List<Student> getAll() {
		return (List<Student>) service.getAllStd();
	}

	@DeleteMapping("/delete/{stdId}")
	public void delete(@PathVariable Integer stdId) {
		service.deleteStd(stdId);
	}

	@GetMapping("/getOne/{stdId}")
	public Student getOne(@PathVariable Integer stdId) {
		return service.getOneStd(stdId);
	}

	@PutMapping("/edit/{stdId}")
	public Student update(@RequestBody Student std, @PathVariable Integer stdId) {
		return service.updateStd(std, stdId);
	}
}
