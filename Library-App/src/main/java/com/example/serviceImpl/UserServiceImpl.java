package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Users;
import com.example.repository.UserRepo;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo repo;
	
	@Override
	public Users saveUser(Users user) {
		
		Users savedUsers = repo.save(user);
		
		return savedUsers;
	}

	
	@Override
	public List<Users> getAllUsers() {

		List<Users> usersList = repo.findAll();		
		
		return usersList;
	}


	@Override
	public void deleteUsers(Long id) {
		
		repo.deleteById(id);
		
	}


	@Override
	public Users getUserById(Long id) {
	
	Users user = repo.findById(id).orElse(null);
		
		return user;
	}
	
	

}
