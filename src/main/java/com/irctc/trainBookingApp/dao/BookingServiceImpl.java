package com.irctc.trainBookingApp.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.trainBookingApp.DTO.BookingDTO;
import com.irctc.trainBookingApp.customExceptions.BookingNotFoundException;
import com.irctc.trainBookingApp.customExceptions.NoAvailableSeatsOnTrain;
import com.irctc.trainBookingApp.customExceptions.PassengerNotFoundException;
import com.irctc.trainBookingApp.customExceptions.TrainNotFoundException;
import com.irctc.trainBookingApp.entities.Booking;
import com.irctc.trainBookingApp.entities.Passenger;
import com.irctc.trainBookingApp.entities.Train;
import com.irctc.trainBookingApp.repository.BookingRepository;
import com.irctc.trainBookingApp.repository.PassengerRepository;
import com.irctc.trainBookingApp.repository.TrainRepository;
import com.irctc.trainBookingApp.service.BookingService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Service

public class BookingServiceImpl implements BookingService {

	
	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private TrainRepository trainRepository;
	@Autowired
	private PassengerRepository passengerRepository;

	@Override
	public List<Booking> GetBookingforPassenger(long passengerId) throws PassengerNotFoundException {
		 passengerRepository.findById(passengerId).orElseThrow(
				() -> new PassengerNotFoundException("Passenger with "+passengerId+" does not exists"));
					return bookingRepository.findByPassengerId(passengerId);
	}

	@Override
	public Booking deleteYourBooking(String ticketNumber) throws BookingNotFoundException {
		Booking booking = bookingRepository.findByTicketNumber(ticketNumber).orElseThrow(() -> new BookingNotFoundException("Booking with ticket number"+ ticketNumber + " does not exists"));
		Train train = booking.getTrain();
	    train.setAvailableSeats(train.getAvailableSeats() + 1);
		bookingRepository.delete(booking);
		return booking;
	}

	@Override
	public Booking addBooking(BookingDTO bookingRequest)
			throws TrainNotFoundException, PassengerNotFoundException, NoAvailableSeatsOnTrain {
		Train train = trainRepository.findById(bookingRequest.getTrainId())
				.orElseThrow(() -> new TrainNotFoundException("Enter valid Train Details"));
		Passenger passenger = passengerRepository.findById(bookingRequest.getPassengerId())
				.orElseThrow(() -> new PassengerNotFoundException("Enter Passenger Details Does not Exists"));
		if (train.getAvailableSeats() < 1)
			throw new NoAvailableSeatsOnTrain("Sold Out");
		else
			train.setAvailableSeats(train.getAvailableSeats() - 1);
		Booking booking = new Booking();
		booking.setTicketNumber(UUID.randomUUID().toString());
		booking.setTrain(train);
		booking.setPassenger(passenger);
		return bookingRepository.save(booking);

	}

}


