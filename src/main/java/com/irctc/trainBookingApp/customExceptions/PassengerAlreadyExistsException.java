package com.irctc.trainBookingApp.customExceptions;

import com.irctc.trainBookingApp.advice.ErrorResponse;

import lombok.Data;
@Data
public class PassengerAlreadyExistsException extends RuntimeException{

	public final ErrorResponse errorResoponse;
	public PassengerAlreadyExistsException(String message , ErrorResponse errorResponse) {
		super(message);
		this.errorResoponse = errorResponse;
		this.errorResoponse.setMessage(message);
	}
	
}
