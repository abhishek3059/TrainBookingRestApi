package com.irctc.trainBookingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.trainBookingApp.customExceptions.PassengerAlreadyExistsException;
import com.irctc.trainBookingApp.customExceptions.PassengerNotFoundException;
import com.irctc.trainBookingApp.entities.Passenger;
import com.irctc.trainBookingApp.service.PassengerService;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @PostMapping
    public Passenger registerPassenger(@RequestBody Passenger passenger) throws PassengerAlreadyExistsException {
        return passengerService.register(passenger);
    }

    @GetMapping("/{id}")
    public Passenger getPassenger(@PathVariable Long id) throws PassengerNotFoundException {
        return passengerService.getPassengerById(id);
    }
}

