package com.example.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UsersDto {

	private Long id;
	
	@NotBlank(message= "Name is required..!")
	private String name;
	
	@NotBlank(message = "Email is required..!")
	@Email(message = "Invalid EMail format..!")
	private String email;
	
	@NotBlank(message = "Address is required")
	private String address;
	
	@NotBlank(message = "Aadhar is required")
	private String aadhar;
	
	@NotBlank(message = "Pan is required")
	private String pan;
	
	@NotBlank(message = "Password is required")
	@Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$" , message="minimum 8 characters in length , At least one uppercase ,one lowercase , one digit, one special character.")
	private String password;
	
}
