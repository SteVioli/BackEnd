package com.SpringBoot_Lezione6_Esercizio.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class MyException extends ResponseEntityExceptionHandler {
	
	   @ExceptionHandler(RuntimeException.class) //nel caso in cui si verifichi un eccezione di tipo RuntimeException
	    public ResponseEntity<String> yyHandlerRuntimeException(RuntimeException e){
	        return new ResponseEntity<String>("Errore!!!!", HttpStatus.NOT_FOUND);
	        //tu intercettala e gestiscila in questo modo. così la scrivo solo qua anzichè in N punti della mia applicazione
	    }
	
}
