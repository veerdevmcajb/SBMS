package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="product api where you can add the product and category",
							  description = "product related Api",
							  version = "v1",
							  contact = @Contact(name="veerdevmca.api",
									  			 email = "veerdevmca@gmail.com",
									  			 url = "www.xyz.com"),
							  license = @License(name = "xyz",
									  			 url = "www.instagram.com")),
							  servers = @Server(url = "localhost:8080", description = "running in local server")
				)
public class ProductApi01Application {

	public static void main(String[] args) {
		SpringApplication.run(ProductApi01Application.class, args);
	}

}
