package com.irctc.trainBookingApp.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.irctc.trainBookingApp.customExceptions.BookingNotFoundException;
import com.irctc.trainBookingApp.customExceptions.NoAvailableSeatsOnTrain;
import com.irctc.trainBookingApp.customExceptions.PassengerAlreadyExistsException;
import com.irctc.trainBookingApp.customExceptions.PassengerNotFoundException;
import com.irctc.trainBookingApp.customExceptions.TrainAlreadyExistsException;
import com.irctc.trainBookingApp.customExceptions.TrainNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> throwNullPointerException(NullPointerException nullPointerException) {
        logger.error("NullPointerException occurred: ", nullPointerException);
        return new ResponseEntity<String>(nullPointerException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TrainNotFoundException.class)
    public ResponseEntity<Object> throwTrainNotFoundException(TrainNotFoundException trainNotFoundException) {
        logger.error("TrainNotFoundException occurred: ", trainNotFoundException);
        ErrorResponse errorResponse = trainNotFoundException.getErrorResoponse();
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<Object> throwBookingNotFoundException(BookingNotFoundException bookingNotFoundException) {
        logger.error("BookingNotFoundException occurred: ", bookingNotFoundException);
        ErrorResponse errorResponse = bookingNotFoundException.getErrorResoponse();
        return new ResponseEntity<>(errorResponse.getMessage(), errorResponse.getStatus());
    }

    @ExceptionHandler(PassengerAlreadyExistsException.class)
    public ResponseEntity<Object> throwPassengerAlreadyExistsException(PassengerAlreadyExistsException passengerAlreadyExistsException) {
        logger.error("PassengerNotFoundException occurred: ", passengerAlreadyExistsException);
        ErrorResponse errorResponse = passengerAlreadyExistsException.getErrorResoponse();
        return new ResponseEntity<>(errorResponse.getMessage(), errorResponse.getStatus());
    }
    @ExceptionHandler(PassengerNotFoundException.class)
    public ResponseEntity<Object> throwPassengerNotFoundException(PassengerNotFoundException passengerNotFoundException) {
        logger.error("PassengerNotFoundException occurred: ", passengerNotFoundException);
        ErrorResponse errorResponse = passengerNotFoundException.getErrorResoponse();
        return new ResponseEntity<>(errorResponse.getMessage(), errorResponse.getStatus());
    }
    @ExceptionHandler(TrainAlreadyExistsException.class)
    public ResponseEntity<Object> throwTrainNotFoundException(TrainAlreadyExistsException trainAlreadyExistsException) {
        logger.error("TrainNotFoundException occurred: ", trainAlreadyExistsException);
        ErrorResponse errorResponse = trainAlreadyExistsException.getErrorResoponse();
        return new ResponseEntity<>(errorResponse.getMessage(), errorResponse.getStatus());
    }
    @ExceptionHandler(NoAvailableSeatsOnTrain.class)
    public ResponseEntity<Object> throwTrainNotFoundException(NoAvailableSeatsOnTrain noAvailableSeatsOnTrain) {
        logger.error("TrainNotFoundException occurred: ", noAvailableSeatsOnTrain);
        ErrorResponse errorResponse = noAvailableSeatsOnTrain.getErrorResoponse();
        return new ResponseEntity<>(errorResponse.getMessage(), errorResponse.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        logger.error("An unexpected error occurred: ", ex);
        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

   
}
