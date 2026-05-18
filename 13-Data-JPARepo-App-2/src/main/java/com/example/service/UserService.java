package com.example.service;

import com.example.entity.UserInfo;
import com.example.repo.UserInfoRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	public UserInfoRepo userRepo;
	
	public void getUserWithSort() {
		List<UserInfo> users = userRepo.findAll();
		users.forEach(System.out::println);
	}
	
	public void getUserSortWithAge() {
		Sort sort = Sort.by("age").ascending();
		
		List<UserInfo> users = userRepo.findAll(sort);
		users.forEach(System.out::println);
	}
	
	public void getUserSortByName() {
		Sort sort =Sort.by("name").ascending();
		
		List<UserInfo> users = userRepo.findAll(sort);
		users.forEach(System.out::println);
	}
	
	
	// Pagination 
	public void getUserWithPagination() {
	
		Integer pageNum = 1;
		Integer pageSize = 3;
		
		PageRequest pageReq = PageRequest.of(pageNum-1, pageSize);
	
		Page<UserInfo> page = userRepo.findAll(pageReq);	
	
		List<UserInfo> users = page.getContent();
		
		users.forEach(System.out::println);
		
	}
	
	public void qbe() {
		
		UserInfo user = new UserInfo();
		
		user.setGender("Male");
		user.setCountry("US");
		
		Example<UserInfo> of = Example.of(user);
		
		List<UserInfo> userList = userRepo.findAll(of);
		userList.forEach(System.out::println);
	
	}
	
}
