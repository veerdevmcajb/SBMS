package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dto.UsersDto;
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
		
		model.addAttribute("userdto", new UsersDto());
		
		return "register";
	}
	
	
	@PostMapping("/save")
	public String saveUsers(UsersDto userdto) {
		
		
		service.saveUser(userdto);
		
		return "redirect:/allusers";
	}
	
	
	@GetMapping("/allusers")
	public String viewAllUsers(Model model) {
		
		List<UsersDto> dtolist  = service.getAllUsers();
		
		model.addAttribute("userlist",dtolist);
		
		return "viewall";
	}
	
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	// to show edit page
	@GetMapping("/editUser/{id}")
	public String editUser(@PathVariable Long id , Model model) {
		
		UsersDto dto = service.getUserById(id);
		
		model.addAttribute("userdto", dto);
		
		return "edit";
	}
	
	
	
	@PostMapping("/update")
	public String updateUser(@ModelAttribute UsersDto userdto) {
		
//		Users existingUser = service.getUserById(user.getId());
//		
//		if(existingUser !=null) {
//			existingUser.setName(user.getName());
//			existingUser.setEmail(user.getEmail());
//			existingUser.setAddress(user.getAddress());
//			existingUser.setAadhar(user.getAadhar());
//			existingUser.setPan(user.getPan());
//			
//			service.saveUser(existingUser);
//		
//		}
		service.saveUser(userdto);
		
		return "redirect:/allusers";
	}
	
	
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		
		service.deleteUsers(id);
		
		return "redirect:/allusers";
	}
}
