package com.SpringBoot_Lezione7_exercise.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class VeicoloException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(EntityExistsException.class)
	protected ResponseEntity<String> manageEntityExistsExceptions(EntityExistsException e){
		return new ResponseEntity<String>(e.getMessage() + " from VeicoloException", HttpStatus.FOUND);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<String> manageEntityNotFoundException(EntityNotFoundException e){
		return new ResponseEntity<String>(e.getMessage() + " from VeicoloException", HttpStatus.FOUND);
	}
	
}
