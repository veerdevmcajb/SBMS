package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Controller
public class UserController {

	 @Autowired
	    private UserRepository repo;

	 
	    // Load Login Page
	    @GetMapping("/")
	    public String loginPage(Model model) {

	        model.addAttribute("user", new User());

	        return "login";
	    }

	    
	    // Load Register Page
	    @GetMapping("/register")
	    public String registerPage(Model model) {

	        model.addAttribute("user", new User());

	        return "register";
	    }

	    
	    
	    // Save User
	    @PostMapping("/saveUser")
	    public String saveUser(User user, Model model) {

	        repo.save(user);

	        model.addAttribute("msg", "Registration Successful Please Login");

	        model.addAttribute("user", new User());

	        return "login";
	    }
	    
	    
	    
	    // Login Check
	    @PostMapping("/login")
	    public String login(User user, Model model) {

	        User validUser =
	                repo.findByEmailAndPassword(
	                        user.getEmail(),
	                        user.getPassword());

	        if (validUser != null) {

	            List<User> users = repo.findAll();

	            model.addAttribute("users", users);

	            return "welcome";
	        }

	        model.addAttribute("msg", "Invalid Credentials");

	        return "login";
	    }

	    
	    
	    // Display All Users
	    @GetMapping("/users")
	    public String getUsers(Model model) {

	        List<User> users = repo.findAll();

	        model.addAttribute("users", users);

	        return "user";
	    }
	    
	    
}
