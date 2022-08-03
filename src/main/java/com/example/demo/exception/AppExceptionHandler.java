package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.shared.ErrorMessage;

@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = {EntityNotFound.class})
	public ResponseEntity<Object> entityNotFoundException(EntityNotFound ex) {
		ErrorMessage errMsg = ErrorMessage.builder().Message(ex.getMessage()).time(new Date()).code(404).build();
		return new ResponseEntity<>(errMsg,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(value = {EntityAlredyExistsException.class})
	public ResponseEntity<Object> entityAlredyExistsException(EntityAlredyExistsException ex) {
		ErrorMessage errMsg = ErrorMessage.builder().Message(ex.getMessage()).time(new Date()).code(409).build();
		return new ResponseEntity<>(errMsg,HttpStatus.CONFLICT);
		
	}
	
	@ExceptionHandler(value = {IllegalArgumentException.class })
	public ResponseEntity<Object> IllegalArgumentException(IllegalArgumentException ex) {
		ErrorMessage errMsg = ErrorMessage.builder().Message("Bad Request").time(new Date()).code(400).build();
		return new ResponseEntity<>(errMsg,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(value = { HttpMessageNotReadableException.class})
	public ResponseEntity<Object> HttpMessageNotReadableException(HttpMessageNotReadableException ex) {
		ErrorMessage errMsg = ErrorMessage.builder().Message("Bad Request").time(new Date()).code(400).build();
		return new ResponseEntity<>(errMsg,HttpStatus.BAD_REQUEST);
		
	}
}
