package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class QuoteController {
	
	

	@GetMapping("/msg1")
	public String getMsg1(@RequestParam String name) {
		
		String msg = "Hi, " + name;
		
		return msg;
	}

	@GetMapping("/msg2/{name}")
	public String getMsg2(@PathVariable String name) {
		
		String msg = "Hello, " + name;
		
		return msg;
	}
}
