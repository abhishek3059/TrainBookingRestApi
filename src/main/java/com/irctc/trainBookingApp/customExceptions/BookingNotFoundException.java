package com.irctc.trainBookingApp.customExceptions;

import com.irctc.trainBookingApp.advice.ErrorResponse;

import lombok.Data;
@Data
public class BookingNotFoundException extends RuntimeException{
	public final ErrorResponse errorResoponse;
	public BookingNotFoundException(String message , ErrorResponse errorResponse) {
		super(message);
		this.errorResoponse = errorResponse;
		this.errorResoponse.setMessage(message);
	}
	
}
