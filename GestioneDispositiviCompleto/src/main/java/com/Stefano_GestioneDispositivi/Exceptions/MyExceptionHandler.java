package com.Stefano_GestioneDispositivi.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.Stefano_GestioneDispositivi.exception.MyAPIException;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {
	
	//per i test che voglio fare mi specifico 2 errori da lanciare in caso di esistenza delle entità 
	
	@ExceptionHandler(MyAPIException.class)
	protected ResponseEntity<String> manageEntityExistsException(MyAPIException e){
		return new ResponseEntity<String>(e.getMessage() + " EPICODE SERVER ERROR MyEXHa", HttpStatus.FOUND);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<String> manageEntityNotFoundException(EntityNotFoundException e){
		return new ResponseEntity<String>(e.getMessage() + " EPICODE SERVER ERROR MyEXHa", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	protected ResponseEntity<String> manageEntityIllegalArgument(IllegalArgumentException e){
		return new ResponseEntity<String>(e.getMessage() + " EPICODE SERVER ERROR MyEXHa", HttpStatus.INSUFFICIENT_STORAGE);
	}
}
