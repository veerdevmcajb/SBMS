package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Car;

public class MainApp {

	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Bran.xml");
		
		Car c = context.getBean(Car.class);
		c.drive();
	}
	
}
