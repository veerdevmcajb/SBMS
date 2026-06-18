package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Student;
import java.util.List;


public interface StudentRepo extends JpaRepository<Student, Integer> {

	List<Student> findByBatch(String batch);
	
	
	Student findByName(String name);
}
