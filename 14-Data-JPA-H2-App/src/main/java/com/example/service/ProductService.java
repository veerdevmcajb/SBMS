package com.example.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;

	
	public void saveProduct() {
		
		Product p = new Product();
		
		p.setProductId(101);
		p.setProductName("Mouse");
		p.setProductPrice(500.00);
		
		productRepo.save(p);
		
		Product p1= new Product();
		p1.setProductId(102);
		p1.setProductName("Keybord");
		p1.setProductPrice(800.00);
		
		Product p2= new Product();
		p2.setProductId(103);
		p2.setProductName("Monitor");
		p2.setProductPrice(2000.00);
		
		List<Product> pList = Arrays.asList(p1,p2);
		
		productRepo.saveAll(pList);
	}
	
	public void getAllDetails() {
		List<Product> all = productRepo.findAll();
		all.forEach(System.out::println);
	
	}

	
			
}
