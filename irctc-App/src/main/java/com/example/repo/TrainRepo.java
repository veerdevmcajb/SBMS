package com.example.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Train;

@Repository
public interface TrainRepo extends JpaRepository<Train, Long> {

	Optional <Train> findByTrainNumber(String trainNumber);

	Optional<Train> findByTrainNameIgnoreCase(String trainName);
	
	List<Train>findBySourceIgnoreCaseAndDestinationIgnoreCase(String source, String desti);
	
	
	
}
