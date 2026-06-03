package com.example.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.UsersDto;
import com.example.entity.Users;
import com.example.helper.UserMapper;
import com.example.repository.UserRepo;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo repo;
	
	@Override
	public UsersDto saveUser(UsersDto userdto) {
		
		// dto obj to entity obj conversion using helper class
		
		
		Users user = UserMapper.dtoToEntity(userdto);
		
		Users savedEntity = repo.save(user);
		
		//convert saved entity to again dto
		
		UsersDto dto = UserMapper.entityToDto(savedEntity);

		return dto;
		
	}

	
	
	@Override
	public UsersDto updateUser(UsersDto userdto) {
		// TODO Auto-generated method stub
		
		Users userEntity = repo.findById(userdto.getId()).orElse(null);
		
		if(userEntity !=null) {
			
			userEntity.setName(userdto.getName());
			userEntity.setEmail(userdto.getEmail());
			userEntity.setAddress(userdto.getAddress());
			
			Users savedEntity = repo.save(userEntity);
			
			return UserMapper.entityToDto(savedEntity);
			
		} 
		
		return null;
	}
	
	
	@Override
	public List<UsersDto> getAllUsers() {

		List<Users> userslist = repo.findAll();		
		
		List<UsersDto> dtoList = userslist.stream().map(entity->UserMapper.entityToDto(entity)).collect(Collectors.toList());
		
		return dtoList;
	}


	@Override
	public void deleteUsers(Long id) {
		
		repo.deleteById(id);
		
	}


	@Override
	public UsersDto getUserById(Long id) {
	
	Users user = repo.findById(id).orElse(null);
		
	// convert entity to dto
		return UserMapper.entityToDto(user);
	}


	
	

}
