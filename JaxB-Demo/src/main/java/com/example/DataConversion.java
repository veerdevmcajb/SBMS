package com.example;


import java.io.File;

import org.springframework.stereotype.Component;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

@Component
public class DataConversion {
	
	public void javaToXml() throws JAXBException {
		
		User u = new User();
		u.setId(101);
		u.setName("Veer");
		u.setEmail("veer@g.com");
		
	JAXBContext ctx	= JAXBContext.newInstance(User.class);
		Marshaller mar = ctx.createMarshaller();
		mar.marshal(u, new File("User.xml"));
	}

	
	public void xmlToJava() throws JAXBException {
		
		File file = new File("User.xml");
		
		JAXBContext ctxt = JAXBContext.newInstance(User.class);
		
		Unmarshaller unmar = ctxt.createUnmarshaller();
		User u = (User)unmar.unmarshal(file);
		
		System.out.println(u);
	}
}
