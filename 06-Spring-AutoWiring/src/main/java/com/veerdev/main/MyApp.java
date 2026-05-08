package com.veerdev.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.veerdev.config.AppConfig;
import com.veerdev.service.UserService;

import io.micrometer.observation.Observation.Context;

public class MyApp {

	public static void main(String[] args) {
		
	
	ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	
	UserService bean= context.getBean(UserService.class);
	
	bean.printName();
	}
	
	
}
