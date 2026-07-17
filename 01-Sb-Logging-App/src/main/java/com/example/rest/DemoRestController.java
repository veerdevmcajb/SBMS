package com.example.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DemoRestController {

	
	@GetMapping("/demo")
	public String getDemoMsg() {
		
		log.debug("This is debug msg");
		String msg = "This is Demo method msg";
		
		log.info("This is info msg");

		log.warn("This is Warn msg");
		
		log.error("This is error msg");
		
		return msg;
	}
}
