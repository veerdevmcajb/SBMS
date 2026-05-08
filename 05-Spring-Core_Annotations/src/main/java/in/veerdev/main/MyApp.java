package in.veerdev.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.veerdev.config.AppConfig;
import in.veerdev.service.UserService;

public class MyApp {

	public static void main(String[] args) {
		
	
	ApplicationContext ctxt = new AnnotationConfigApplicationContext(AppConfig.class);
	UserService bean = ctxt.getBean(UserService.class);
	bean.getName();
	}
}
