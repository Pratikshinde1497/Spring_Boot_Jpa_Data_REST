package com.shinde.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shinde.demo.dao.StudentRepo;
import com.shinde.demo.models.Student;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
	
	@Autowired
	private StudentRepo repo;
	
	@GetMapping("/")
	public String getHome() {
		return "Welome to Spring Boot Data REST Tutorial";
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		
		return repo.findAll();
	}
}
