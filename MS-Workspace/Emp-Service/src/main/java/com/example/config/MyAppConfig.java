package com.example.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MyAppConfig {

	@Bean
	public ModelMapper modelmapper() {
		
		return new ModelMapper();
	}
	
//	@Bean
//	@Primary
//	public WebClient webClient() {
//		
//		return WebClient.builder().build();
//	}
	
	
//	@Bean("shiv")
//	WebClient getPostman() {
//		WebClient webClient = WebClient.builder()
//		.baseUrl("http://localhost:8081/department").build();
//	
//		return webClient;
//		
//	}
}
