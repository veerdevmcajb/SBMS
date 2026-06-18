package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Train;
import com.example.entity.TrainTicket;
import com.example.repo.TicketRepo;
import com.example.repo.TrainRepo;
import com.example.service.TrainService;

@Service
public class TrainServiceImpl implements TrainService{

	@Autowired
	private TrainRepo trainrepo;
	
	@Autowired
	private TicketRepo ticketRepo;

	@Override
	public String addTrain(Train train) {
		
		trainrepo.save(train);
		
		return "train added.";
	}

	@Override
	public Train getTrainByTrainNo(String tno) {
		
		Train train = trainrepo.findByTrainNumber(tno).orElseThrow(()->new RuntimeException("Train not found"));
		
		return train;
	}

	
	@Override
	public List<Train> getTrainBySourceDesti(String source, String destination) {
		// TODO Auto-generated method stub
		List<Train> trains = trainrepo.findBySourceIgnoreCaseAndDestinationIgnoreCase(source, destination);
		return trains;
	}	

	@Override
	public TrainTicket bookTain(String passName, String trainName) {
		// TODO Auto-generated method stub
		
		//Train train	= trainrepo.findByTrainNumber(trainName).orElseThrow(()-> new RuntimeException("Invalid train num"));
		
		Train train = trainrepo.findByTrainNameIgnoreCase(trainName).orElseThrow(()->new RuntimeException("Invalid train Name"));
	
		TrainTicket ticket = new TrainTicket();
		ticket.setPassangerName(passName);
		ticket.setArriveTime(train.getArriveTime());
		ticket.setDepartTime(train.getDepartTime());
		ticket.setTrainName(train.getTrainName());
		ticket.setPrice(train.getPrice());
		ticket.setSource(train.getSource());
		ticket.setDestination(train.getDestination());
		ticket.setTrainNumber(train.getTrainNumber());
		
		TrainTicket trainTicket = ticketRepo.save(ticket);
		
		return trainTicket;
	}
	
	
	
}
