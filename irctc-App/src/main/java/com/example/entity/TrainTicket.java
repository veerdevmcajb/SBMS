package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TrainTicket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String passangerName;
	
	@Column(unique = true)
	private String trainNumber;
	private String trainName;
	private String source;
	private String destination;
	private String departTime;
	private String arriveTime;
	private double price;
	
}
