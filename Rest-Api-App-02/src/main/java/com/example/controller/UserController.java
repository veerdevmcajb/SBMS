package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	
	// create user / save user
	
	@PostMapping("/saveuser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User saveUser = service.createuser(user);
		
		return new ResponseEntity<User>(saveUser, HttpStatus.OK);
	}
	
	// for update user Data
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Long id,  @RequestBody User user){
		
		User myuser = service.getUserById(id);
		if(myuser == null) {
			return new ResponseEntity<>("user not found with id " +id , HttpStatus.NOT_FOUND);
		}
		
		User updateUser = service.updateUser(id, user);
		
		return new ResponseEntity<>(updateUser,HttpStatus.OK);	
	}
	
	
	// get user 
	@GetMapping("/getuser/{id}")
	public ResponseEntity<?> getUser(@PathVariable Long id){
		
		User user = service.getUserById(id);
		if(user==null) {
			return new ResponseEntity<>("user not found with id " + id , HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	
	// delete user
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id){
		
		User userById = service.getUserById(id);
	
		if(userById == null) {
			return new ResponseEntity<>("user not found with id " + id, HttpStatus.NOT_FOUND);
		}
		
		service.deleteUser(id);
		return new ResponseEntity<>("user deleted + " + id , HttpStatus.OK);
	}
	
	
	@GetMapping("/allusers")
	public ResponseEntity<?> getAllUsers(){
		List<User> allUsers = service.getAllUsers();
		
		if(allUsers.isEmpty()) {
			return new ResponseEntity<>(" No record found ", HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<>(allUsers, HttpStatus.OK);
	}
	
}
