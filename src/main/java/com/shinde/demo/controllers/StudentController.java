package com.shinde.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/students")
	public Student postStudent(@RequestBody Student student) {
		
		return repo.save(student);
	}
	
	@DeleteMapping("/students/{rno}")
	public String postStudent(@PathVariable ("rno") int rno) {

		if(repo.existsById(rno)) {
			repo.deleteById(rno);
			return "Deleted entry of rno " + rno;
		}
		else return "Not Found";
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {

		return repo.save(student);
	}
	
	@GetMapping("/students/names")
	public List<String> getNames() {
		
		return repo.getSnames();
	}
	
	@GetMapping("/students/names/{name}")
	public List<Student> getNamesByname(@PathVariable("name") String name) {
		
		return repo.findBySname(name);
	}
	
	@GetMapping("/students/getByMarkSorted/{mark}")
	public List<Student> getByMarkSorted(@PathVariable("mark") int mark) {
		Object res = repo.findByMarkSortedBySname(mark);
		return repo.findByMarkSortedBySname(mark);
	}
	
	@GetMapping("/students/marks_GT/{mark}")
	public List<Student> getNames(@PathVariable("mark") int mark) {
		
		return repo.findByMarksGreaterThan(mark);
	}
	
}
