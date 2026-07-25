package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.City;

@Repository
public interface CityRepo extends JpaRepository<City, Long>{

	
	
}
