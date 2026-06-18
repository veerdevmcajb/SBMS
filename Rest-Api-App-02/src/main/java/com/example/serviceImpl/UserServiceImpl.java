package com.example.serviceImpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repo.UserRepo;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo urRepo;

	
	@Override
	public User createuser(User user) {

		return urRepo.save(user);
	}

	
	
	@Override
	public User updateUser(Long id, User user) {

		Optional<User> opt = urRepo.findById(id);
		
		if(opt.isPresent()) {
			
			User existingUser = opt.get();
			existingUser.setName(user.getName());
			existingUser.setEmail(user.getEmail());
			existingUser.setAbout(user.getAbout());
			return urRepo.save(existingUser);
			
		}
		else {
			throw new RuntimeException("User not found with id " + id);
		}	
	}

	
	
	@Override
	public List<User> getAllUsers() {
		
		return urRepo.findAll();
	}

	@Override
	public void deleteUser(Long id) {
		
		urRepo.findById(id);
		
	}

	@Override
	public User getUserById(Long id) {
		User orElseThrow = urRepo.findById(id).orElseThrow(()->new RuntimeException("User not found"));

		return orElseThrow;
	}
	
}
