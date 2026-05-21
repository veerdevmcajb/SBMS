package com.example;

import com.example.service.PersonService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    private final PersonService personService;

    Application(PersonService personService) {
        this.personService = personService;
    }

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		PersonService personService = context.getBean(PersonService.class);
	
		//personService.savePersonWIthPassport();
		
		//personService.getPerson(1);
		
		personService.deletePerson(2);
	}

}
