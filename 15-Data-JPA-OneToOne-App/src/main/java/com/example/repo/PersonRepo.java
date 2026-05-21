package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Passport;
import com.example.entity.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

	
}
