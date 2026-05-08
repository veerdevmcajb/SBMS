package com.veerdev.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "com.veerdev")
public class AppConfig {
	
	public AppConfig() {
		System.out.println("AppConfig :: Constructor");
	}

}
