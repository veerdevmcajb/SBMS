package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.binding.Student;

@Controller
public class StudentController {

	// method to load student form
	// model is used to send the data from controller to view.
	// model is a map which is used to store the data in the form of key and value format.
	
	public String loadForm(Model model) {
		
		List<String> coursesList = new ArrayList<>();
		coursesList.add("Java");
		coursesList.add("Python");
		coursesList.add("Devops");
		coursesList.add("AWS");
		
		
		List<String> timingsList = new ArrayList<>();
		timingsList.add("Morning");
		timingsList.add("Afternoon");
		timingsList.add("Evening");
		
		
		model.addAttribute("courses" , coursesList);
		model.addAttribute("timings",timingsList);
		
		Student student = new Student();
		model.addAttribute("Student", student);
		
		
		return "index";
	}
	// method to save student form data
	
	// method to display saved student data 
}
