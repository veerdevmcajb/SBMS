package com.example.service;



import com.example.dto.EmployeeDto;
import com.example.dto.ResponseDto;

public interface EmployeeService {

	// to save emp
	EmployeeDto saveEmployee(EmployeeDto employeedto);

	// get emp by id
	ResponseDto getEmpWithDept(Integer id);

	// to get emp data with dept data 
	EmployeeDto getEmployeeByid(Integer id);

	
}
