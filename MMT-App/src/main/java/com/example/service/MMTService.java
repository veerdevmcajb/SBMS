package com.example.service;



import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import com.example.controller.MmtController;
import com.example.response.TicketRequest;
import com.example.response.Train;
import com.example.response.TrainTicket;

@Service
public class MMTService {

   //private final MmtController mmtController;

	private static final String BASE_URL ="http://localhost:8080/train";
	
	
	@Autowired
	private RestTemplate restTemplate;


//    MMTService(MmtController mmtController) {
//        this.mmtController = mmtController;
//    }
//	
	
	public List<Train> searchTrain(String source , String destination){
		
		String url=BASE_URL +"/search?source="+source +"&destination="+destination;
		
		ResponseEntity<Train[]> response = restTemplate.getForEntity(url, Train[].class);
		
		Train[] train = response.getBody();
		
		List<Train> trains = Arrays.asList(train);
		
		return trains;
	}
	
	
	public TrainTicket bookTrain(TicketRequest ticketRequest) {
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<TicketRequest> requestENtity = new HttpEntity<>(ticketRequest,headers);
		
		ResponseEntity<TrainTicket> response = restTemplate.postForEntity(BASE_URL +"/book", requestENtity, TrainTicket.class);
		
		
		TrainTicket ticket = response.getBody();
		
		return ticket;
		
	}
}
