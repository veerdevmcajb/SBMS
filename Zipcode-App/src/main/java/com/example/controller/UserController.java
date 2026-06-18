package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.dto.RequestDto;
import com.example.dto.ResponseDto;
import com.example.service.ZipcodeService;

@Controller
public class UserController {

	@Autowired
	private ZipcodeService zipService;
    
   
	@GetMapping("/")
	public String showHomePage(Model model) {
		
		model.addAttribute("requestdto", new RequestDto());
		
		return "home";
		
	}
	
	public String searchZip(@ModelAttribute("requestdto") RequestDto requestdto , Model model) {
		
		ResponseDto resp = zipService.getInfoByZipCode(requestdto.getCountry(),requestdto.getZipCode() );
		model.addAttribute("requestdto", new RequestDto());
		
		if(resp ==null) {
			model.addAttribute("No Data Found..!");
		}else {
			model.addAttribute("zipresponse",resp);
		}
		return"home";
		
	}
	
	
}
