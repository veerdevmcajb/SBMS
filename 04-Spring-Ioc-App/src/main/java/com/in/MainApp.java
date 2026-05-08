package com.in;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	
	public static void main(String[] args) {
		
		ApplicationContext ctxt= new ClassPathXmlApplicationContext("beans.xml");
		
		UserService userService = ctxt.getBean(UserService.class);
		
		userService.register("Veer", "veer@gmail.com", 1234567l);
	}

}
