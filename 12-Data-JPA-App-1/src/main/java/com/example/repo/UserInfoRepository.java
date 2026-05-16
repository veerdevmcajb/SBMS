package com.example.repo;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.example.entity.*;

import jakarta.transaction.Transactional;

public interface UserInfoRepository extends  CrudRepository<UserInfo, Integer>{
	
	// How to retrive records based on non-primry column values--> Using findBy() methods we can acheive this.
	
	// select * from user_info where country=?
	public List<UserInfo>findByCountry(String counry);
	
	// select * from user_info where gender=?
	public List<UserInfo>findByGender(String gender);
	
	public List<UserInfo>findByCountryAndGender(String country , String gender);
	
	public List<UserInfo>findByAgeGreaterThanEqual(Integer age);
	
	public List<UserInfo>findByCountryAndAge(String country, Integer age);
	
	
	// custom Query
	@Query(value = "select * from user_info" , nativeQuery=true)
	public List<UserInfo>getData();
	
	@Query("From UserInfo")
	public List<UserInfo>m1();
	
	@Transactional
	@Modifying
	@Query("delete from UserInfo where userId = :userId")
	public void deleteUserWithHQL(Integer userId);
	

}
