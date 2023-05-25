package com.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.Student;
import com.web.repo.StudentRepo;

@Service
public class StudentService extends Student {
	@Autowired
	private StudentRepo repo;

	public Student insertStd(Student std) {
		double total = (std.getS1() + std.getS2() + std.getS3());
		std.setTotal(total);
		double avg = total / 3;
		std.setPercentage(avg);
		String grade;
		if (avg > 70) {
			grade = "A Grade";
			std.setGrade(grade);
		} else if (avg > 60 && avg <= 70) {
			grade = "B Grade";
			std.setGrade(grade);
		} else if (avg > 50 && avg <= 60) {
			grade = "C Grade";
			std.setGrade(grade);
		} else if (avg <= 50) {
			grade = "Fail";
			std.setGrade(grade);
		}
		return repo.save(std);
	}

	public List<Student> getAllStd() {
		return (List<Student>) repo.findAll();
	}

	public void deleteStd(Integer stdId) {
		repo.deleteById(stdId);
	}

	public Student getOneStd(Integer stdId) {
		return repo.findById(stdId).get();
	}

	public Student updateStd(Student std, Integer stdId) {
		Optional<Student> optional = repo.findById(stdId);
		Student s1 = optional.get();
		s1.setStdId(stdId);
		s1.setName(std.getName());
		s1.setCourse(std.getCourse());
		s1.setFee(std.getFee());
		s1.setS1(std.getS1());
		s1.setS2(std.getS2());
		s1.setS3(std.getS3());
		double total = (s1.getS1() + s1.getS2() + s1.getS3());
		s1.setTotal(total);
		double avg = total / 3;
		s1.setPercentage(avg);
		String grade;
		if (avg > 70) {
			grade = "A Grade";
			s1.setGrade(grade);
		} else if (avg > 60 && avg <= 70) {
			grade = "B Grade";
			s1.setGrade(grade);
		} else if (avg > 50 && avg <= 60) {
			grade = "C Grade";
			s1.setGrade(grade);
		} else if (avg <= 50) {
			grade = "Fail";
			s1.setGrade(grade);
		}
		return repo.save(s1);

	}
}
