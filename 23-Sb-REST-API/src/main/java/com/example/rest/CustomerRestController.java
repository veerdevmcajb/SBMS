package com.example.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Customer;

@RestController
public class CustomerRestController {

	@GetMapping(value = "/customer" ,
			produces = {"application.json"})
	public ResponseEntity<Customer> getCustomer(){
		
		Customer c= new Customer("1","Veer","veer@g.com");
		return new ResponseEntity<Customer>(c,HttpStatus.OK);
	}
}
