package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/msg")
public class MsgController {

	@GetMapping("/welcome")
	public ModelAndView getWelComeMsg() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("msg","Welcome to Spring Web MVC");
		
		mav.setViewName("index");
		
		return mav;
	}
	
	@GetMapping("/greet")
	public String getGreetMsg(Model model) {
		
		System.out.println("model impl class Name is : " + model.getClass().getName());
		
		model.addAttribute("msg","Good Morning");
		
		return ("index");
	}
	
	@GetMapping("/test")
	@ResponseBody
	public String txtMsg() {
		
		return "This is The Text Msg Coming From Controller Method.";
	}
	
	
}
