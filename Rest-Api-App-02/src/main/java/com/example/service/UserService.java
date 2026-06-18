package com.example.service;

import java.util.List;

import com.example.entity.User;

public interface UserService{
	
	User createuser(User user);

	User updateUser(Long id , User user);
	
	List<User>getAllUsers();
	
	void deleteUser(Long id);
	
	User getUserById(Long id);
}
