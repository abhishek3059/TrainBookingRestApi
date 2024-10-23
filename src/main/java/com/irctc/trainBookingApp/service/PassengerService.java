package com.irctc.trainBookingApp.service;

import java.util.List;

import com.irctc.trainBookingApp.customExceptions.PassengerAlreadyExistsException;
import com.irctc.trainBookingApp.customExceptions.PassengerNotFoundException;
import com.irctc.trainBookingApp.entities.Passenger;

public interface PassengerService {
	public List<Passenger> getAllPassengers() throws PassengerNotFoundException;
	public Passenger register(Passenger passenger) throws PassengerAlreadyExistsException;
	public Passenger getPassengerById(long id) throws PassengerNotFoundException;
	

}
