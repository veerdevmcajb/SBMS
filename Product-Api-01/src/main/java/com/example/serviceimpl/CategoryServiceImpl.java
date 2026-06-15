package com.example.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.CategoryDto;
import com.example.entity.Category;
import com.example.repo.CateRepo;
import com.example.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CateRepo catRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto catDto) {
		
		// convert category Dto to entity
		
		Category catEntity = modelMapper.map(catDto, Category.class);
		
		// save this categoru to entity
		Category entity = catRepo.save(catEntity);
		
		// convert entity to dto
		
		CategoryDto dto = modelMapper.map(entity, CategoryDto.class);
		
		return dto;
	}

	
	@Override
	public List<CategoryDto> getAllCategory() {
	
		List<Category> categories = catRepo.findAll();
		
		List<CategoryDto> dtolist = categories.stream().map(cat-> modelMapper.map(cat,CategoryDto.class)).collect(Collectors.toList());
		
		return dtolist;
	}
	
	

}
 