package com.irctc.trainBookingApp.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.irctc.trainBookingApp.customExceptions.BookingNotFoundException;
import com.irctc.trainBookingApp.customExceptions.NoAvailableSeatsOnTrain;
import com.irctc.trainBookingApp.customExceptions.PassengerAlreadyExistsException;
import com.irctc.trainBookingApp.customExceptions.PassengerNotFoundException;
import com.irctc.trainBookingApp.customExceptions.TrainAlreadyExistsException;
import com.irctc.trainBookingApp.customExceptions.TrainNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> throwNullPointerException(NullPointerException nullPointerException) {
        logger.error("NullPointerException occurred: ", nullPointerException);
        return new ResponseEntity<>(nullPointerException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TrainNotFoundException.class)
    public ResponseEntity<String> throwTrainNotFoundException(TrainNotFoundException trainNotFoundException) {
        logger.error("TrainNotFoundException occurred: ", trainNotFoundException);
        return new ResponseEntity<>(trainNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<String> throwBookingNotFoundException(BookingNotFoundException bookingNotFoundException) {
        logger.error("BookingNotFoundException occurred: ", bookingNotFoundException);
        return new ResponseEntity<>(bookingNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PassengerAlreadyExistsException.class)
    public ResponseEntity<String> throwPassengerAlreadyExistsException(PassengerAlreadyExistsException passengerAlreadyExistsException) {
        logger.error("PassengerNotFoundException occurred: ", passengerAlreadyExistsException);
        return new ResponseEntity<>(passengerAlreadyExistsException.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PassengerNotFoundException.class)
    public ResponseEntity<String> throwPassengerNotFoundException(PassengerNotFoundException passengerNotFoundException) {
        logger.error("PassengerNotFoundException occurred: ", passengerNotFoundException);
        return new ResponseEntity<>(passengerNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(TrainAlreadyExistsException.class)
    public ResponseEntity<String> throwTrainNotFoundException(TrainAlreadyExistsException trainAlreadyExistsException) {
        logger.error("TrainNotFoundException occurred: ", trainAlreadyExistsException);
        return new ResponseEntity<>(trainAlreadyExistsException.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NoAvailableSeatsOnTrain.class)
    public ResponseEntity<String> throwTrainNotFoundException(NoAvailableSeatsOnTrain noAvailableSeatsOnTrain) {
        logger.error("TrainNotFoundException occurred: ", noAvailableSeatsOnTrain);
        return new ResponseEntity<>(noAvailableSeatsOnTrain.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        logger.error("An unexpected error occurred: ", ex);
        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(
//        MethodArgumentNotValidException ex,
//        HttpHeaders headers,
//        HttpStatus status,
//        WebRequest request) {
//
//        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
//            .map(FieldError::getDefaultMessage)
//            .collect(Collectors.joining(", "));
//        
//        logger.error("Method argument not valid: {}", errorMessage);
//        
//        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
//    }
}
