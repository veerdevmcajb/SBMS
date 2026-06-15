package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CategoryDto;
import com.example.service.CategoryService;

@RestController
@RequestMapping("/cat")
public class CategoryController {

	@Autowired
	private CategoryService catservice;
	
	@PostMapping("/save")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
		
		CategoryDto category = catservice.createCategory(categoryDto);
		
		return new ResponseEntity<CategoryDto>(category,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/categories")
	public ResponseEntity<List<CategoryDto>> allCategories(){
		
		List<CategoryDto> allCategory = catservice.getAllCategory();
		
		return new ResponseEntity<List<CategoryDto>>(allCategory,HttpStatus.OK);
	}
}
