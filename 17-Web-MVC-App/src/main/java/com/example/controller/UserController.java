package com.example.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bindings.User;

@Controller
public class UserController {
	
	@PostMapping("/user")
	@ResponseBody
	public String addUser(@RequestBody User user) {
		
		System.out.println(user);
		
		return "User Added";
	}

	@GetMapping("/user")
	@ResponseBody
	public User getUser() {
		User u = new User();
		
		u.setId(101);
		u.setName("Bablu");
		u.setGender("Male");
		u.setPhno(123456789l);
		
		return u;
	}
	
	@GetMapping("/users")
	@ResponseBody
	public List<User> getUsers(){
		
		User u1= new User();
		u1.setId(101);
		u1.setName("Natha");
		u1.setGender("Male");
		u1.setPhno(123987456l);
		
		User u2= new User();
		u2.setId(102);
		u2.setName("Priya");
		u2.setGender("Fe-Male");
		u2.setPhno(987654123l);
		
		User u3= new User();
		u3.setId(103);
		u3.setName("Nitya");
		u3.setGender("Fe-Male");
		u3.setPhno(774589622l);
		
		return Arrays.asList(u1,u2,u3);
		
	}
}
