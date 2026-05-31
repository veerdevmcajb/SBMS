package com.example.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class StudentEntity {

	private Integer sId;
	private String sName;
	private String email;
	private String gender;
	private String course;
	private String timing;
}
