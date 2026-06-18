package com.example.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MyAppConfig {

	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper();
	}
	
	@Bean
	public WebClient webClient() {
		
		return WebClient.builder().build();
		
	}
	
	
	
	@Bean("vijay")
	WebClient getPostman() {
		WebClient webClient = WebClient.builder()
					.baseUrl("http://localhost:8081/course").build();
		
		return webClient;
	}
	
	
}
