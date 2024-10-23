package com.irctc.trainBookingApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irctc.trainBookingApp.entities.Train;
@Repository
public interface TrainRepository extends JpaRepository<Train, Long>{
 public Optional<Train> findByTrainNumber(String trainNumber);
 public boolean existsByTrainNumber(String trainNumber);
 
 
 
}
