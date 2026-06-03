package com.example.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.dto.UsersDto;

public interface UserService {

	// for Save users
	UsersDto saveUser(UsersDto userdto);
	
	UsersDto updateUser(UsersDto userdto);
	
	// to view all users
	
	List<UsersDto>getAllUsers();
	
	public Page<UsersDto> getAllPaginationData(Pageable pageable);
	
	// for delete 
	void deleteUsers(Long id);

	// return user based on id
	UsersDto getUserById(Long id);
	
}
