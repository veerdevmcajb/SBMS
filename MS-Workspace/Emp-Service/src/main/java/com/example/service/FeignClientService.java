package com.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dto.DepartmentDto;

@FeignClient(name = "DEPT-SERVICE")
public interface FeignClientService {

	@GetMapping("department/getdept/{code}")
	DepartmentDto getDeptByCode(@PathVariable String code);
	
}
