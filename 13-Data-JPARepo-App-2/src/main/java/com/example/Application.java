package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.service.UserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		UserService bean = context.getBean(UserService.class);
		
		//bean.getUserWithSort();
		
		//bean.getUserSortWithAge();
		
		//bean.getUserSortByName();
		
		//bean.getUserWithPagination();
		
		bean.qbe();
	}

}
