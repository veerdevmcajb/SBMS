package com.example.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ProductDto;
import com.example.entity.Category;
import com.example.entity.Product;
import com.example.repo.CateRepo;
import com.example.repo.ProdRepo;
import com.example.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProdRepo prodrepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private CateRepo catRepo;
	

	@Override
	public ProductDto createProduct(ProductDto productDto) {
		
				// convert category Dto to entity
				Product product = modelMapper.map(productDto, Product.class);
				
				Category category = catRepo.findById(productDto.getCategoryId()).orElseThrow(()->new RuntimeException("Invalid category id"));
				
				product.setCategory(category);
				
				Product saveProd = prodrepo.save(product);
				
				// convert entity to dto
				
				ProductDto dto = modelMapper.map(saveProd, ProductDto.class);
				
				return dto;
	 }

	@Override
	public List<ProductDto> getAllProduct() {
		
		List<Product> products = prodrepo.findAll();
		List<ProductDto> proddtolist = products.stream().map(p-> modelMapper.map(p, ProductDto.class)).collect(Collectors.toList());
		
		return proddtolist;
	}

	@Override
	public ProductDto updateProduct(Long prodid, ProductDto dto) {
		
		//fetching existing products
		Product product = prodrepo.findById(prodid).orElseThrow(()->new RuntimeException("product not found "+ prodid));
		
		// updating existing data
		product.setName(dto.getName());
		product.setPdesc(dto.getPdesc());
		product.setPrice(dto.getPrice());
		
		// fetching catgeory object
		// based on if fetch specific catgeory fom DB
		Category category = catRepo.findById(dto.getCategoryId()).orElseThrow(()-> new RuntimeException("invalid category id"));
		
		product.setCategory(category);
		
		Product productentity = prodrepo.save(product);
		
		return modelMapper.map(productentity, ProductDto.class);
	}

	@Override
	public void deleteProduct(Long productid) {
		// TODO Auto-generated method stub
		
	}
	

}
