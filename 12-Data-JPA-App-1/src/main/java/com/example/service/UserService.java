package com.example.service;

import com.example.repo.UserInfoRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.UserInfo;

@Service
public class UserService {

	@Autowired
	private UserInfoRepository userInfoRepo;
	
	public void test() {
		String impl = userInfoRepo.getClass().getName();
		System.out.println("Impl class name is " + impl);
	}
	
	
	public void saveUser() {
		
		UserInfo u = new UserInfo();
		
		u.setUserId(103);
		u.setName("Kishan");
		u.setGender("Male");
		u.setAge(18);
		u.setCountry("India");
		
		userInfoRepo.save(u);
		
		System.out.println("User Saved...");
	
	}
	


	public void getAllUsers() {
		// TODO Auto-generated method stub
		Iterable<UserInfo> all = userInfoRepo.findAll();
		all.forEach(System.out::println);
		
	}
	
	public void getUserById(Integer uid) {
		Optional<UserInfo> byId = userInfoRepo.findById(uid);
		if(byId.isPresent()) {
			System.out.println(byId.get());
		}
	
	}
	
	public void saveAllUsers() {
		
		UserInfo u1= new UserInfo();
		u1.setUserId(106);
		u1.setName("Smriti");
		u1.setGender("Female");
		u1.setAge(28);
		u1.setCountry("India");
		
		UserInfo u2= new UserInfo();
		u2.setUserId(107);
		u2.setName("Priya");
		u2.setGender("Female");
		u2.setAge(25);
		u2.setCountry("India");
		
		List<UserInfo> asList = Arrays.asList(u1,u2);
		
		userInfoRepo.saveAll(asList);
		
	}

	public void callFindByMethods() {
		List<UserInfo> listByGender = userInfoRepo.findByGender("Male");
		listByGender.forEach(System.out::println);
	}
	
	
	// Native Query
	public void executeCustomQuery() {
		List<UserInfo> data = userInfoRepo.getData();
		data.forEach(System.out::println);
		
	}
	
	public void executeHQL() {
		List<UserInfo> list = userInfoRepo.m1();
		list.forEach(System.out::println);
	}
	
	public void executeDeleteHql() {
		userInfoRepo.deleteUserWithHQL(105);
	}
}
