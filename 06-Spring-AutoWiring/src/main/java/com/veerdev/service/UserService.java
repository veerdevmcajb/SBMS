package com.veerdev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veerdev.dao.IUserDao;

@Service
public class UserService {
	
	@Autowired
	private IUserDao userDao;	// field injection 
	
	public UserService() {
	System.out.println("UserService :: Constructor");	
	}
	
	public void printName() {
		String name =userDao.getName(100);
		System.out.println("Name " + name);
	}

}
