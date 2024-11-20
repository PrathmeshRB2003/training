package com.pb.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice //@restControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex){
//		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
//	}

}
