package com.irctc.trainBookingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.trainBookingApp.customExceptions.TrainAlreadyExistsException;
import com.irctc.trainBookingApp.customExceptions.TrainNotFoundException;
import com.irctc.trainBookingApp.entities.Train;
import com.irctc.trainBookingApp.service.TrainService;
@RestController
@RequestMapping("/trains")
public class TrainController {
    @Autowired
    private TrainService trainService;

    @GetMapping
    public List<Train> getAllTrains() throws TrainNotFoundException {
        return trainService.getAllTrains();
    }

    @PostMapping
    public Train addTrain(@RequestBody Train train) throws TrainAlreadyExistsException {
        return trainService.addTrain(train);
    }

    @PutMapping("/{trainNumber}")
    public Train updateTrain(@PathVariable String trainNumber, @RequestBody Train train) throws TrainNotFoundException {
        return trainService.updateTrain(trainNumber, train);
    }

    @DeleteMapping("/{trainNumber}")
    public ResponseEntity<Void> deleteTrain(@PathVariable String trainNumber) throws TrainNotFoundException {
        trainService.deleteTrain(trainNumber);
        return ResponseEntity.noContent().build();
    }
}


