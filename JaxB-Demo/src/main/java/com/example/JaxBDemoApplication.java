package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import jakarta.xml.bind.JAXBException;

@SpringBootApplication
public class JaxBDemoApplication {

	public static void main(String[] args) throws JAXBException {
		ConfigurableApplicationContext run = SpringApplication.run(JaxBDemoApplication.class, args);
		
		DataConversion bean = run.getBean(DataConversion.class);
		
		//bean.javaToXml();
		bean.xmlToJava();
	
	}

	
	
}
