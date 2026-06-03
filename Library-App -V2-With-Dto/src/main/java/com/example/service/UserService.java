package com.example.service;

import java.util.List;

import com.example.dto.UsersDto;
import com.example.entity.Users;

public interface UserService {

	// for Save users
	UsersDto saveUser(UsersDto userdto);
	
	UsersDto updateUser(UsersDto userdto);
	
	// to view all users
	
	List<UsersDto>getAllUsers();
	
	// for delete 
	void deleteUsers(Long id);

	// return user based on id
	UsersDto getUserById(Long id);
	
}
