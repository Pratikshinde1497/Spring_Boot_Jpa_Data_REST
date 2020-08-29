package com.shinde.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shinde.demo.models.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	List<Student> findBySname(String name);
}
