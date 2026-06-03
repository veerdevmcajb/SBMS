package com.example.helper;

import com.example.dto.UsersDto;
import com.example.entity.Users;

public class UserMapper {
	
	// takes dto and return entity.
	
	public static Users dtoToEntity(UsersDto dto) {
		
		// create entity object
		
		Users entityobj = new Users();
		
		entityobj.setId(dto.getId());
		entityobj.setName(dto.getName());
		entityobj.setEmail(dto.getEmail());
		entityobj.setAddress(dto.getAddress());
		entityobj.setAadhar(dto.getAadhar());
		entityobj.setPan(dto.getPan());
		entityobj.setPassword(dto.getPassword());
		
		return entityobj;
		
	}
	
	
	//takes entity and return dto 
	
	public static UsersDto entityToDto(Users user) {
		
		UsersDto dto = new UsersDto();
		
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		dto.setAadhar(user.getAadhar());
		dto.setAddress(user.getAddress());
		dto.setId(user.getId());
		dto.setPan(user.getPan());
		
		return dto;
		
	
	}

}
