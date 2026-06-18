package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CourseDto;
import com.example.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService couservice;
	
	@PostMapping("/save")
	public ResponseEntity<CourseDto>addCourse(@RequestBody CourseDto dto){
		
	CourseDto course = couservice.createCourse(dto);
	
	return new ResponseEntity<CourseDto>(course,HttpStatus.CREATED);
	
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<CourseDto>>getCourse(){
		
		List<CourseDto> course = couservice.getAllCourse();
		
		return new ResponseEntity<>(course,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/get/{name}")
	public ResponseEntity<List<CourseDto>>getCourseByName(@PathVariable String name){
		
	List<CourseDto> course	= couservice.findCourseByName(name);
	
	return new ResponseEntity<List<CourseDto>>(course,HttpStatus.OK);
	}
	
	
	@GetMapping("/getcourse/{code}")
	public ResponseEntity<CourseDto> getCourse(@PathVariable String code){
		CourseDto dto = couservice.getCourse(code);
		return new ResponseEntity<CourseDto>(dto, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
