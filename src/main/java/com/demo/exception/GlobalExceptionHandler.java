package com.demo.exception;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorEntity> userNotFoundException(UserNotFoundException exception) {
		ErrorEntity error = new ErrorEntity(exception.getMessage(), LocalDate.now());
		return new ResponseEntity<ErrorEntity>(error, HttpStatus.NOT_FOUND);
	}
}
