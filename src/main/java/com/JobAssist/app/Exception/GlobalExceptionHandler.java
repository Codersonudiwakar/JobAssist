package com.JobAssist.app.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.JobAssist.app.response.SignupResponse;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<SignupResponse> handleException(Exception ex) {
	    long startTime = Instant.now().toEpochMilli(); // Start time
	    ex.printStackTrace();

	    long responseTime = Instant.now().toEpochMilli() - startTime; // Calculate response time

	    // Constructing SignupResponse with error details
	    SignupResponse response = new SignupResponse(
	        "An error occurred: " + ex.getMessage(), // Message
	        HttpStatus.INTERNAL_SERVER_ERROR.value(), // Status code
	        responseTime, // Response time
	        "NA" // Username is not applicable for exceptions
	    );

	    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}


	@ExceptionHandler(CustomException.class) // Handle custom exceptions
	public ResponseEntity<SignupResponse> handleCustomException(CustomException ex) {
	    long startTime = Instant.now().toEpochMilli(); // Start time
	    ex.printStackTrace();

	    long responseTime = Instant.now().toEpochMilli() - startTime; // Calculate response time

	    SignupResponse response = new SignupResponse(
	        "An error occurred: " + ex.getMessage(), // Error message
	        HttpStatus.BAD_REQUEST.value(), // HTTP status code (400 for bad request)
	        responseTime, // Calculated response time
	        "NA"
	    );

	    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
//	@ExceptionHandler(Exception.class) // Handle custom exceptions
//	public ResponseEntity<SignupResponse> UNAUTHORIZEDException(CustomException ex) {
//	    long startTime = Instant.now().toEpochMilli(); // Start time
//	    ex.printStackTrace();
//
//	    long responseTime = Instant.now().toEpochMilli() - startTime; // Calculate response time
//
//	    SignupResponse response = new SignupResponse(
//	        "An error occurred: " + ex.getMessage(), // Error message
//	        HttpStatus.UNAUTHORIZED.value(), // HTTP status code (400 for bad request)
//	        responseTime, // Calculated response time
//	        "NA"
//	    );
//
//	    return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
//	}
//	
//	@ExceptionHandler(Exception.class) // Handle custom exceptions
//	public ResponseEntity<SignupResponse> FORBIDDENException(CustomException ex) {
//	    long startTime = Instant.now().toEpochMilli(); // Start time
//	    ex.printStackTrace();
//
//	    long responseTime = Instant.now().toEpochMilli() - startTime; // Calculate response time
//
//	    SignupResponse response = new SignupResponse(
//	        "An error occurred: " + ex.getMessage(), // Error message
//	        HttpStatus.FORBIDDEN.value(), // HTTP status code (400 for bad request)
//	        responseTime, // Calculated response time
//	        "NA"
//	    );
//
//	    return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
//	}

    
}
