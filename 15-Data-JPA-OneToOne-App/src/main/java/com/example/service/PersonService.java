package com.example.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Passport;
import com.example.entity.Person;
import com.example.repo.PassportRepo;
import com.example.repo.PersonRepo;

@Service
public class PersonService {

	@Autowired
	private PersonRepo personRepo;
	
	@Autowired
	private PassportRepo passportRepo;
	
	// insert person with passport
	
	public void savePersonWIthPassport() {
		
		Passport passport = new Passport();
		passport.setPassportNum("PQR8877");
		passport.setIssuedDate(LocalDate.now().minusMonths(3));
		passport.setExpDate(LocalDate.now().plusYears(10));
		
		Person person = new Person();
		person.setPersonName("Natha");
		person.setDob(LocalDate.now().minusYears(23));
		
		//association mapping
		
		passport.setPerson(person);
		person.setPassport(passport);
		
		
		//Saving Data
		personRepo.save(person);
		
		
	}
	
	public void getPerson(int personId) {
		personRepo.findById(personId);
	}
	
	public void deletePerson(int personId) {
		personRepo.deleteById(personId);
	}
}
