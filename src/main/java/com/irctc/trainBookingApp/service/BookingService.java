package com.irctc.trainBookingApp.service;

import java.util.List;
import java.util.Optional;

import com.irctc.trainBookingApp.DTO.BookingDTO;
import com.irctc.trainBookingApp.customExceptions.BookingNotFoundException;
import com.irctc.trainBookingApp.customExceptions.NoAvailableSeatsOnTrain;
import com.irctc.trainBookingApp.customExceptions.PassengerNotFoundException;
import com.irctc.trainBookingApp.customExceptions.TrainNotFoundException;
import com.irctc.trainBookingApp.entities.Booking;
import com.irctc.trainBookingApp.entities.Passenger;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface BookingService {
 
	
	
	
 
 


	public Booking deleteYourBooking(String ticketNumber) throws BookingNotFoundException;



	Booking addBooking(BookingDTO bookingRequest) throws TrainNotFoundException, PassengerNotFoundException, NoAvailableSeatsOnTrain;




	List<Booking> GetBookingforPassenger(long passengerId) throws PassengerNotFoundException;
  
	  
  
}
