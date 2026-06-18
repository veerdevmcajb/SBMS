package com.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.ResponseDto;
import com.example.service.ZipcodeService;

@Service
public class ZipCodeServiceImpl implements ZipcodeService{

	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	@Override
	public ResponseDto getInfoByZipCode(String countryCode, String zipCode) {
		
		String url ="https://api.zippopotam.us/" + countryCode +"/" + zipCode;
		
		try {
			
			ResponseEntity<ResponseDto> resp = restTemplate.getForEntity(url, ResponseDto.class);
			
			if(resp.getStatusCode().is2xxSuccessful() && resp.getBody()!=null) {
				return resp.getBody();
			}else {
				return null;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
		
	}

	
}
