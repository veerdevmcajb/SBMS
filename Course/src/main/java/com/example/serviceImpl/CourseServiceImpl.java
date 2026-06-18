package com.example.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CourseDto;
import com.example.entity.Course;
import com.example.repo.CourseRepo;
import com.example.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseRepo repo;

	@Autowired
	private ModelMapper mapper;
	
	@Override
	public CourseDto createCourse(CourseDto dto) {
		
		// convert dto to entity 
	Course entity	= mapper.map(dto, Course.class);
		
	Course save = repo.save(entity);
	
	// convert entity to dto
	CourseDto codto = mapper.map(save, CourseDto.class);
		
	return codto;
	}

	
		
	@Override
	public List<CourseDto> getAllCourse() {

		List<Course> all = repo.findAll();
		
		List<CourseDto> list = all.stream().map(course->mapper.map(course, CourseDto.class)).collect(Collectors.toList());
		
		
		return list;
	}



	@Override
	public List<CourseDto> findCourseByName(String name) {
	
	
		List<Course> byName = repo.findByName(name);
		
		List<CourseDto> found = byName.stream().map(n->mapper.map(n, CourseDto.class)).collect(Collectors.toList());
		
		return found;
	}



	@Override
	public CourseDto getCourse(String code) {
		Course course = repo.findByCourseCode(code);
		return mapper.map(course, CourseDto.class);
	}



	

}
