package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dto.Ticket;
import com.example.entity.City;
import com.example.service.CityService;

@Controller
public class TicketController {

	@Autowired
	private CityService cityservice;
	
	@GetMapping("/")
	public String showIndexPage() {
		
		return "index";
	}
	
	
	@GetMapping("/book")
	public String showTrainticketForm(Model model) {
		
		List<City> allCity = cityservice.getAllCity();
		
		model.addAttribute("cities",allCity);
		model.addAttribute("ticket" , new Ticket());
		
		return "bookticket";
	}
	
	
	
	@PostMapping("/save")
	public String saveTicket(@ModelAttribute("ticket")  Ticket ticket, Model model) {
		
		String fullName = ticket.getFirstName() +" " + ticket.getLastName() ;
		
		String fromCity = ticket.getFromCity();
		String toCity = ticket.getToCity();
		
		String msg = "Hi " + fullName + "Your Ticket Is Booked " + fromCity + "To " + toCity ;
		
		model.addAttribute("msg",msg);
		
		return "success"; 
	}
}
