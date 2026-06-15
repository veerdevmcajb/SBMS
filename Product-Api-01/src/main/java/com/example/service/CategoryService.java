package com.example.service;

import java.util.List;

import com.example.dto.CategoryDto;

public interface CategoryService {

	CategoryDto createCategory(CategoryDto catDto);
	
	List<CategoryDto>getAllCategory();
	
	
}
