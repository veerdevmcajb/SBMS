package com.example.service;

import com.example.dto.ResponseDto;

public interface ZipcodeService {

	ResponseDto getInfoByZipCode(String countryCode, String zipCode);
	
}
