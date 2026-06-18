package com.example.service;

import java.util.List;

import com.example.dto.CourseDto;

public interface CourseService {

	// for create a courde
	CourseDto createCourse(CourseDto dto);

	// for get all course 
	List<CourseDto> getAllCourse();

	List<CourseDto> findCourseByName(String name);

	CourseDto getCourse(String code);

	

}
