package com.example.service;

import java.util.List;

import com.example.dto.CourseDto;
import com.example.dto.ResponseDto;
import com.example.dto.StudentDto;

public interface StudentService {

	StudentDto createStudent(StudentDto dto);

	List<StudentDto> getAllStdByBatch(String batch);

	List<CourseDto>getCourseByName(String name);

	ResponseDto findInfo(String stdName);

}
