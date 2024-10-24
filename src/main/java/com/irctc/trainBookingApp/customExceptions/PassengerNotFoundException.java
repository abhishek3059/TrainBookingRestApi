package com.irctc.trainBookingApp.customExceptions;

import com.irctc.trainBookingApp.advice.ErrorResponse;

import lombok.Data;
@Data
public class PassengerNotFoundException extends RuntimeException{
	

	public final ErrorResponse errorResoponse;
	public PassengerNotFoundException(String message , ErrorResponse errorResponse) {
		super(message);
		this.errorResoponse = errorResponse;
		this.errorResoponse.setMessage(message);
	}
	 

}
