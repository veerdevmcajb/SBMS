package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;


@Entity
@Data
public class UserInfo {
	
	@Id
	private Integer userId;
	private String name;
	private String gender;
	private String country;
	private Integer age;
	
	

	
}
