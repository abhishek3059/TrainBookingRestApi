package com.irctc.trainBookingApp.advice;

import org.springframework.http.HttpStatus;

import lombok.Data;
@Data
public class ErrorResponse {
    private String message;
    private HttpStatus status;

    public ErrorResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    // Getters and Setters
}

