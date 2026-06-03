package com.example.service;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.dto.UsersDto;

import jakarta.servlet.http.HttpServletResponse;

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
	
	// for excel generation
	public void generateExce(HttpServletResponse resp) throws IOException ;
	
	
	// for pdf generation
	public void generatePdf(HttpServletResponse resp ) throws Exception;
	
	
}
