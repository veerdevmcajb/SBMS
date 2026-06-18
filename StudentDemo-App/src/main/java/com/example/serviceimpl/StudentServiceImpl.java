package com.example.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.dto.CourseDto;
import com.example.dto.ResponseDto;
import com.example.dto.StudentDto;
import com.example.entity.Student;
import com.example.repo.StudentRepo;
import com.example.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepo repo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private WebClient webClient;
	
	@Autowired
	@Qualifier("vijay")
	private WebClient postman;
	
	
	@Override
	public StudentDto createStudent(StudentDto studentdto) {
	
		// conver dto to entity
		Student entity = mapper.map(studentdto, Student.class);
		
		Student save = repo.save(entity);
		
		// convert dto to entity
		StudentDto dto = mapper.map(save, StudentDto.class);
		return dto;
	}


	@Override
	public List<StudentDto> getAllStdByBatch(String batch) {
		
		 List<Student> byBatch = repo.findByBatch(batch);
		
		List<StudentDto> dtolist = byBatch.stream().map(ba->mapper.map(ba, StudentDto.class)).collect(Collectors.toList());
		
		return dtolist;
	}


	@Override
	public List<CourseDto> getCourseByName(String name) {
		
		
		return webClient.get()
				.uri("http://localhost:8081/course/get/{name}",name)
				.retrieve()
				.bodyToFlux(CourseDto.class)
				.collectList()
				.block();
							
	}


	@Override
	public ResponseDto findInfo(String stdName) {
		
		Student found = repo.findByName(stdName);
		
		System.out.println(found);
		
		String courseCode = found.getCourseCode();
		
		ResponseDto dto = new ResponseDto();
		dto.setStudentdto(mapper.map(found, StudentDto.class));
		// done with half part lets do the communication now
		
		
		CourseDto courseDto = postman.get()
				.uri(req-> req.path("/getcourse/{code}").build(courseCode))
				.retrieve()
				.bodyToMono(CourseDto.class)
				.block();
		
		dto.setDto(courseDto);
		return dto;
	}

	
}
