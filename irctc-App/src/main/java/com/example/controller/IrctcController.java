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

import com.example.entity.Train;
import com.example.entity.TrainTicket;
import com.example.requestdto.TicketRequest;
import com.example.service.TrainService;

@RestController
@RequestMapping("/train")
public class IrctcController {

	@Autowired
	private TrainService trainService;
	
	// to add the train
	
	@PostMapping("/add")
	public ResponseEntity<String> addTrain(@RequestBody Train train){
		
		String msg = trainService.addTrain(train);
	
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/book")
	public ResponseEntity<TrainTicket> bookTicket(@RequestBody TicketRequest ticket){
		
		TrainTicket trainTicket = trainService.bookTain(ticket.getPassName(), ticket.getTrainName());
		
		return new ResponseEntity<>(trainTicket , HttpStatus.CREATED);
	}
	
	
	@GetMapping("/search")
	public ResponseEntity<List<Train>> searchTrain(@RequestParam String source , @RequestParam String destination){
		
		List<Train> trains = trainService.getTrainBySourceDesti(source, destination);
		return new ResponseEntity<>(trains , HttpStatus.CREATED);		
	}
}
