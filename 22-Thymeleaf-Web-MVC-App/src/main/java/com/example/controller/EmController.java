package com.example.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.model.Employee;

@Controller
public class EmController {

   

	@GetMapping("/")
	public String homePage(Model model) {
		
		Employee e1 = new Employee("Raj","raj@g.com","HR","12345");
		Employee e2 = new Employee("Veer","veer@g.com","Tester","112233");
		Employee e3 = new Employee("Natha","natha@g.com","BA","998877");
		Employee e4 = new Employee("Bablu","bablu@g.com","Dev","852369");
		Employee e5 = new Employee("Ram","ram@g.com","Admin","741258");
		
		List<Employee> listEmp =Arrays.asList(e1,e2,e3,e4,e5);
		model.addAttribute("emp",listEmp);
		
		return "home";
	}
	
	@GetMapping("/register")
	public String createUser() {
		
		return "register-user";
	}
	
	@GetMapping("/aboutus")
	public String aboutus() {
		
		return "about";
	}
	
	@GetMapping("/contactus")
	public String contactus() {
		
		return "contact";
	}
	
	@GetMapping("/product")
	public String product() {
		
		return "product";
	}
	
	
}
