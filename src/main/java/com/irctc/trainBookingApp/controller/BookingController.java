package com.irctc.trainBookingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.trainBookingApp.DTO.BookingDTO;
import com.irctc.trainBookingApp.customExceptions.BookingNotFoundException;
import com.irctc.trainBookingApp.customExceptions.NoAvailableSeatsOnTrain;
import com.irctc.trainBookingApp.customExceptions.PassengerNotFoundException;
import com.irctc.trainBookingApp.customExceptions.TrainNotFoundException;
import com.irctc.trainBookingApp.entities.Booking;
import com.irctc.trainBookingApp.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking bookTicket(@RequestBody BookingDTO bookingRequest) throws TrainNotFoundException, PassengerNotFoundException, NoAvailableSeatsOnTrain {
        return bookingService.addBooking(bookingRequest);
    }

    @GetMapping("/{passengerId}")
    public List<Booking> getBookingsForPassenger(@PathVariable Long passengerId) throws PassengerNotFoundException {
        return bookingService.GetBookingforPassenger(passengerId);
    }

    @DeleteMapping("/{ticketNumber}")
    public ResponseEntity<Void> cancelBooking(@PathVariable String ticketNumber) throws BookingNotFoundException {
        bookingService.deleteYourBooking(ticketNumber);
        return ResponseEntity.noContent().build();
    }
}

