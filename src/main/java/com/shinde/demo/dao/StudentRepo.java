package com.shinde.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shinde.demo.models.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
	@Query(value = "select sname from student",  nativeQuery = true)
	List<String> getSnames();
	
	List<Student> findBySname(String name);
	
	List<Student> findByMarksGreaterThan(int mark);
	
	@Query("from Student where marks=?1 order by sname")
	List<Student> findByMarkSortedBySname(int mark);
}
