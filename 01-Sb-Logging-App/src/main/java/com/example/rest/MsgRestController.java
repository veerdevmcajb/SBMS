package com.example.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MsgRestController {


	private Logger logger= LoggerFactory.getLogger(MsgRestController.class);

	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		
		logger.debug("method started");
		
		String msg = "Welcome to Logger App";
		
		logger.info("method executed successfully");
		
		String name = null;
		
		try {
			System.out.println(name.length());
		}
		catch (Exception e){
			logger.error(e.getMessage());
		}
		
		logger.debug("method ended");
		
		return msg;
	}
	
	
	@GetMapping("/greet")
	public String getGreetMsg() {
		
		String msg = "Good Morning";
		return msg;
	}


}
