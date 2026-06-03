package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.entity.Users;
import com.example.repository.UserRepo;
import com.example.service.UserService;

@Controller
public class UserController {

    private final UserRepo userRepo;


	@Autowired
	private UserService service;


    UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


   
	@GetMapping("/")
	public String showHomePage() {
		
		return "home";
		
	}
	
	
	@GetMapping("/register")
	public String showregisterPage(Model model) {
		
		model.addAttribute("user", new Users());
		
		return "register";
	}
	
	
	@PostMapping("/save")
	public String saveUsers(Users user) {
		
		System.out.println(user.getName() +" " + user.getAadhar());
		
		service.saveUser(user);
		
		return "redirect:/allusers";
	}
	
	
	@GetMapping("/allusers")
	public String viewAllUsers(Model model) {
		
		List<Users> allUsers = service.getAllUsers();
		
		model.addAttribute("userlist",allUsers);
		
		return "viewall";
	}
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	// to show edit page
	@GetMapping("/editUser/{id}")
	public String editUser(@PathVariable Long id , Model model) {
		
		Users userById = service.getUserById(id);
		
		model.addAttribute("user",userById);
		
		System.out.println(id);
		return "edit";
	}
	
	
	@PostMapping("/update")
	public String updateUser(@ModelAttribute Users user) {
		
		Users existingUser = service.getUserById(user.getId());
		
		if(existingUser !=null) {
			existingUser.setName(user.getName());
			existingUser.setEmail(user.getEmail());
			existingUser.setAddress(user.getAddress());
			existingUser.setAadhar(user.getAadhar());
			existingUser.setPan(user.getPan());
			
			service.saveUser(existingUser);
		
		}
		
		return "redirect:/allusers";
	}
	
	
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		
		service.deleteUsers(id);
		
		return "redirect:/allusers";
	}
}
