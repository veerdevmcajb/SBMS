package com.example.serviceimpl;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.DepartmentDto;
import com.example.dto.EmployeeDto;
import com.example.dto.ResponseDto;
import com.example.entity.Employee;
import com.example.repository.EmployeeRepo;
import com.example.service.EmployeeService;
import com.example.service.FeignClientService;

import io.github.resilience4j.retry.annotation.Retry;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo repo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private FeignClientService feighservice;
	
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeedto) {
		
		Employee entity = mapper.map(employeedto, Employee.class);
		Employee employee = repo.save(entity);
		EmployeeDto dto = mapper.map(employee, EmployeeDto.class);
		return dto;
	}

	
	public EmployeeDto getEmployeeByid(Integer id) {
		
		Employee emp = repo.findById(id).orElseThrow(()->new RuntimeException("Invalid Emp ID"));
		
		return mapper.map(emp, EmployeeDto.class);
		
	}

	

	@Override
	@Retry(name="EMP-SERVICE",fallbackMethod="getEmpWithDeptFallback")
	public ResponseDto getEmpWithDept(Integer id) {
		
		System.out.println("Trying to call dept service ");
		// fetch first the emp data by id 
		Employee emp = repo.findById(id).orElseThrow(()->new RuntimeException("Invalid Emp ID"));

		// convert emp to dto
			EmployeeDto empdto = mapper.map(emp, EmployeeDto.class);
			
			DepartmentDto deptdto = feighservice.getDeptByCode(emp.getDeptCode());
			
			// prepare Response Object
			
			ResponseDto dto = new ResponseDto();
			dto.setDeptdto(deptdto);
			dto.setEmpdto(empdto);
			
		return dto;
	}

	
	// fallback logic 
	public ResponseDto getEmpWithDeptFallback(Integer id, Exception ex) {
		
		System.out.println("Fallback logic triggered for " + ex.getMessage());
		
		Employee emp = repo.findById(id).orElseThrow(()->new RuntimeException("Invalid Emp ID"));

		EmployeeDto empdto = mapper.map(emp, EmployeeDto.class);
			
		DepartmentDto deptdto = new DepartmentDto();
		
		deptdto.setDeptAddress("N/A");
		deptdto.setDeptName("department service down");
		deptdto.setDepDesc("this is fallback logic ");
			
		ResponseDto dto = new ResponseDto();
		dto.setDeptdto(deptdto);
		dto.setEmpdto(empdto);
		
		
		return dto;
	}
	

	
	
}
