package com.irctc.trainBookingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irctc.trainBookingApp.entities.Passenger;
@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long>{
	public boolean existsByContactDetails(String contactDetails);
}
