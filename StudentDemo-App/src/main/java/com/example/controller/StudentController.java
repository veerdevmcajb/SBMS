package com.example.controller;

import java.util.List;

import org.jspecify.annotations.Nullable;
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
import com.example.dto.ResponseDto;
import com.example.dto.StudentDto;
import com.example.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService stdservice;
	
	@PostMapping("/save")
	public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto dto){
		
		StudentDto student = stdservice.createStudent(dto);
		
		return new ResponseEntity<StudentDto>(student,HttpStatus.CREATED);	
	}
	
	@GetMapping("/get/{batch}")
	public ResponseEntity<List<StudentDto>>getStudentByBatch(@PathVariable String batch){
		
	List<StudentDto>students = stdservice.getAllStdByBatch(batch);
	
	return new ResponseEntity<List<StudentDto>>(students,HttpStatus.OK);
	
	}
	
	
	@GetMapping("/courses/{name}")
	public ResponseEntity<List<StudentDto>>getCourse(@PathVariable String name){
		
	@Nullable List<CourseDto> course = stdservice.getCourseByName(name);
	
	return new ResponseEntity<List<StudentDto>>(HttpStatus.OK);
	
	}
	
	
	@GetMapping("/findstudent/{stdName}")
		public ResponseEntity<ResponseDto> getTotalInfo(@PathVariable String stdName){
			ResponseDto response = stdservice.findInfo(stdName);
			return new ResponseEntity<ResponseDto>(response, HttpStatus.OK);
		}
	
	
	
	
	
	
	
	
	
	
	
	
}

