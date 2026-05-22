package com.example.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Address;
import com.example.entity.Employee;
import com.example.repo.AddRepo;
import com.example.repo.EmpRepo;

@Service
public class EmpService {
	
	@Autowired
	private AddRepo addRepo;
	
	@Autowired
	private EmpRepo empRepo;
	
	public void saveEmpWithAddList() {
		
		Address a1 = new Address();
		a1.setCity("Pune");
		a1.setState("MH");
		a1.setCountry("India");
		
		Address a2 = new Address();
		a2.setCity("Nanded");
		a2.setState("MH");
		a2.setCountry("India");
		
		Employee e = new Employee();
		e.setEmpName("Veer");
		e.setEmpSalary(35000.00);
		
		//assocation emp to address
		
		a1.setEmp(e);
		a2.setEmp(e);
		
		// assocate addList to emp
		e.setAddList(Arrays.asList(a1,a2));
		
		// save Parent
		empRepo.save(e);
		
	}
	
	public void getEmp(int id) {
		empRepo.findById(id);
	}
	
	public void getAdd(int id) {
		addRepo.findById(id);
	}
	
	public void deleteAddress(int addId) {
		Address address = addRepo.findById(addId).orElseThrow();
		
		Employee emp = address.getEmp();
		
		emp.getAddList().remove(address);
		
		address.setEmp(null);
		
		addRepo.delete(address);
	}
}
