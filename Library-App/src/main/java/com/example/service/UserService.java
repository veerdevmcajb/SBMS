package com.example.service;

import java.util.List;

import com.example.entity.Users;

public interface UserService {

	// for Save users
	Users saveUser(Users user);
	
	// to view all users
	
	List<Users>getAllUsers();
	
	// for delete 
	void deleteUsers(Long id);

	// return user based on id
	Users getUserById(Long id);
	
}
