package com.irctc.trainBookingApp.service;

import java.util.ArrayList;
import java.util.List;

import com.irctc.trainBookingApp.customExceptions.TrainAlreadyExistsException;
import com.irctc.trainBookingApp.customExceptions.TrainNotFoundException;
import com.irctc.trainBookingApp.entities.Train;

public interface TrainService{
	
	public List<Train> getAllTrains() throws TrainNotFoundException;
	public Train addTrain(Train train) throws TrainAlreadyExistsException;
	public Train updateTrain(String trainNumber , Train trainToUpdate) throws TrainNotFoundException;
	public Train deleteTrain (String trainNumner) throws TrainNotFoundException;
	public Train trainByTrainNo(String trainNumber) throws TrainNotFoundException;

}
