package com.irctc.trainBookingApp.customExceptions;

import com.irctc.trainBookingApp.advice.ErrorResponse;

import lombok.Data;
@Data
public class NoAvailableSeatsOnTrain extends RuntimeException {
	
	public final ErrorResponse errorResoponse;
	public NoAvailableSeatsOnTrain(String message , ErrorResponse errorResponse) {
		super(message);
		this.errorResoponse = errorResponse;
		this.errorResoponse.setMessage(message);
	}
	

}
