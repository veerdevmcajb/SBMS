package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.response.TicketRequest;
import com.example.response.Train;
import com.example.response.TrainTicket;
import com.example.service.MMTService;

@RestController
@RequestMapping("/mmt")
public class MmtController {

	@Autowired
	private MMTService mmtservice;
	
	@GetMapping("/mmtsearch")
	public ResponseEntity<List<Train>>searchTrains(@RequestParam String source , @RequestParam String destination){
		
	
		List<Train> trains = mmtservice.searchTrain(source, destination);
		return new ResponseEntity<List<Train>>(trains,HttpStatus.OK);
	}
	
	
	@PostMapping("/booktrain")
	public ResponseEntity<TrainTicket> bookTrain(@RequestBody TicketRequest ticketRequest){
	
		TrainTicket trainTicket = mmtservice.bookTrain(ticketRequest);
		
		return new ResponseEntity<>(trainTicket,HttpStatus.CREATED);
	}
}
