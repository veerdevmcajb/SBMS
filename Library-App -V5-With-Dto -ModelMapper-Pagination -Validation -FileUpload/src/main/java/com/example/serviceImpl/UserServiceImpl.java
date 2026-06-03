package com.example.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.dto.UsersDto;
import com.example.entity.Users;
import com.example.repository.UserRepo;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo repo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public UsersDto saveUser(UsersDto userdto) {
		
		// dto obj to entity obj conversion using helper class
		
		
		Users user = mapper.map(userdto, Users.class);
		
		
		Users savedEntity = repo.save(user);
		
		//convert saved entity to again dto
		UsersDto dto = mapper.map(savedEntity, UsersDto.class);

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
			
			return mapper.map(savedEntity, UsersDto.class);
			
		} 
		
		return null;
	}
	
	
	@Override
	public List<UsersDto> getAllUsers() {

		List<Users> userslist = repo.findAll();		
		
		List<UsersDto> dtoList = userslist.stream().map(entity->mapper.map(entity, UsersDto.class)).collect(Collectors.toList());
		
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
		return mapper.map(user, UsersDto.class);
	}



	@Override
	public Page<UsersDto> getAllPaginationData(Pageable pageable) {
	Page<Users> pages = repo.findAll(pageable);
	
	Page<UsersDto> dtopages = pages.map(u->mapper.map(u, UsersDto.class));
	
	return dtopages;
	}


	
	

}
