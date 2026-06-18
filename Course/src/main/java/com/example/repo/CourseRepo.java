package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Course;
import java.util.List;




public interface CourseRepo extends JpaRepository<Course, Integer>{
	
	List<Course> findByName(String name);
	
	
	Course findByCourseCode(String courseCode);
	
}
