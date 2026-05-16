package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.entity.UserInfo;
import com.example.service.UserService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		
		UserService bean = run.getBean(UserService.class);
		//bean.test();
		
		//bean.saveUser();
		//bean.getAllUsers();
		//bean.getUserById(102);
		//bean.saveAllUsers();
		
		//bean.callFindByMethods();
		
		//bean.executeCustomQuery();
		
		//bean.executeHQL();
	
		bean.executeDeleteHql();
	}

}
