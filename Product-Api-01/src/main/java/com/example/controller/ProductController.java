package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ProductDto;
import com.example.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/prod")
public class ProductController {

	@Autowired
	private ProductService prodService;

	@Operation(summary="to add product" , description = "this will return added product details with categary name")
	@PostMapping("/addprod")
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto dto){
		
		ProductDto product = prodService.createProduct(dto);
		
		return new ResponseEntity<ProductDto>(product,HttpStatus.CREATED);
	}
	
	@Operation(summary="to get All product" , description = "this will return list of products.")
	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> getAllProduct(){
		
		List<ProductDto> allProduct = prodService.getAllProduct();
		
		return new ResponseEntity<>(allProduct,HttpStatus.OK);
	}
	
	@Operation(summary="to update product" , description = "this will return updated products details with category name.")
	@PutMapping("/updateprod/{id}")
	public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id , @RequestBody ProductDto dto){
		
		ProductDto updateProduct = prodService.updateProduct(id, dto);
		return new ResponseEntity<>(updateProduct,HttpStatus.CREATED);
	}
}
