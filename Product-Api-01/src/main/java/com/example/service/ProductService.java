package com.example.service;

import java.util.List;

import com.example.dto.ProductDto;

public interface ProductService {

	// to add products
	ProductDto createProduct(ProductDto productDto);
	
	// to get all products
	List<ProductDto>getAllProduct();
	
	// to update product
	ProductDto updateProduct(Long prodid , ProductDto dto);
	
	// to delete product
	void deleteProduct(Long productid);

}
