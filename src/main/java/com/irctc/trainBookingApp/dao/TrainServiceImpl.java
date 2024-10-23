package com.irctc.trainBookingApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.trainBookingApp.customExceptions.TrainAlreadyExistsException;
import com.irctc.trainBookingApp.customExceptions.TrainNotFoundException;
import com.irctc.trainBookingApp.entities.Train;
import com.irctc.trainBookingApp.repository.TrainRepository;
import com.irctc.trainBookingApp.service.TrainService;

@Service
public class TrainServiceImpl implements TrainService {

	@Autowired
	private TrainRepository trainRepository;

	@Override
	public List<Train> getAllTrains() throws TrainNotFoundException {
			return trainRepository.findAll();
	
	}

	@Override
	public Train updateTrain(String trainNumber , Train trainToUpdate) throws TrainNotFoundException {
		Train train = trainRepository.findByTrainNumber(trainNumber)
					   .orElseThrow(() -> new TrainNotFoundException("Train with " + trainNumber + " does not exists"));
		train.setName(trainToUpdate.getName());
		train.setAvailableSeats(trainToUpdate.getAvailableSeats());
		train.setSource(trainToUpdate.getSource());
		train.setDestination(trainToUpdate.getDestination());
		return trainRepository.save(train);
		
		

	}

	@Override
	public Train deleteTrain(String trainNumber) throws TrainNotFoundException {
		Train train = trainRepository.findByTrainNumber(trainNumber).orElseThrow(
				() -> new TrainNotFoundException("Train with " + trainNumber + " does not exists"));
			 trainRepository.delete(train);
			 return train;
		      	
	}

	@Override
	public Train trainByTrainNo(String trainNumber) throws TrainNotFoundException {
	    return trainRepository.findByTrainNumber(trainNumber).orElseThrow(
				() -> new TrainNotFoundException("Train with " + trainNumber + " does not exists"));
	    	
	}

	@Override
	public Train addTrain(Train train) throws TrainAlreadyExistsException {
		if(trainRepository.existsByTrainNumber(train.getTrainNumber()))
				throw new TrainAlreadyExistsException("Train already exists");
		return trainRepository.save(train);
		
		
	}

}
