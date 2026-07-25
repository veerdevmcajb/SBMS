package com.example.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.City;
import com.example.repo.CityRepo;
import com.example.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepo repo;
	
	
	private Map<String,List<City>> localCache = new HashMap();
	
	
//	@Override
//	public List<City> getAllCity() {
//		
//		System.out.println("data fetched from database...");
//		
//		return repo.findAll();
//	}
	
	
	@Override
	public List<City> getAllCity() {
		
		// first check the local cache means in the map if data is avaliable there
		// then return the data
		
		if(localCache.containsKey("CITIES")) {
			System.out.println("Fetching data from local cache (Hashmap)");
			return localCache.get("CITIES");
		}
		
		System.out.println("data fetched from database...And putting into local cache means Map");
		
		 List<City> all = repo.findAll();
		 
		 localCache.put("CITIES", all);
		 // if data is not avaliable in the map then fetch from DB and stored into the map
		 
		 return all;
	}


}
