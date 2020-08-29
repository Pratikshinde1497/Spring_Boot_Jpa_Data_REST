package com.shinde.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shinde.demo.models.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
