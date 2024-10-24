package com.irctc.trainBookingApp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.irctc.trainBookingApp.advice.ErrorResponse;
import com.irctc.trainBookingApp.customExceptions.PassengerAlreadyExistsException;
import com.irctc.trainBookingApp.customExceptions.PassengerNotFoundException;
import com.irctc.trainBookingApp.entities.Passenger;
import com.irctc.trainBookingApp.repository.PassengerRepository;
import com.irctc.trainBookingApp.service.PassengerService;
@Service
public class PassengerServiceImpl implements PassengerService {
	
	@Autowired
	private PassengerRepository passengerRepository;

	@Override
	public List<Passenger> getAllPassengers() throws PassengerNotFoundException {
		return passengerRepository.findAll();

	}

	@Override
	public Passenger register(Passenger passenger) throws PassengerAlreadyExistsException {
	    ErrorResponse errorResponse = new ErrorResponse("Passenger Already Exists Exception Occured", HttpStatus.CONFLICT);
		if(passengerRepository.existsByContactDetails(passenger.getContactDetails()))
			throw new PassengerAlreadyExistsException("Passenger with "+passenger.getId()+" already exists",errorResponse);
		return passengerRepository.save(passenger);
		
	}

	@Override
	public Passenger getPassengerById(long id) throws PassengerNotFoundException {
		ErrorResponse errorResponse = new ErrorResponse("Passenger Not found Exception Occured", HttpStatus.NOT_FOUND);
	 return passengerRepository.findById(id).orElseThrow(
			 () -> new  PassengerNotFoundException("Passenger with "+id+" does not exists", errorResponse));
	}

	
	

}
