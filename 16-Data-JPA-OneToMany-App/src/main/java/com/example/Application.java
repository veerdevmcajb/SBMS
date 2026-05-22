package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.service.EmpService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext contxt = SpringApplication.run(Application.class, args);
		EmpService bean = contxt.getBean(EmpService.class);
	
		//bean.saveEmpWithAddList();
		
		//bean.getEmp(1);
		
		//bean.getAdd(2);
		
		bean.deleteAddress(2);
		
	}

}
