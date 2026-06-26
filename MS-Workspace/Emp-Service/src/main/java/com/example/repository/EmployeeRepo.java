package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dto.EmployeeDto;
import com.example.entity.Employee;
import java.util.List;





@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	Employee getEmployeeByName(String name);
	
	// find emp by id
	
	EmployeeDto getEmployeeByid(Integer id);
	

}
