package com.example.service;

import java.util.List;

import com.example.entity.Train;
import com.example.entity.TrainTicket;

public interface TrainService {

	// add train
	
	String addTrain(Train train);
	
	// get train By Train number
	Train getTrainByTrainNo(String tno);
	
	
	//get  train by source and sestination
	List<Train> getTrainBySourceDesti(String source, String destination);
	
	
	// book train ticket
	TrainTicket	bookTain(String passName , String trainName);

}
