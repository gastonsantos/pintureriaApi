package com.api.pintureria.Pintureria.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.api.pintureria.Pintureria.Exception.*;
import com.api.pintureria.Pintureria.model.ErrorDto;

@RestControllerAdvice
public class ControllerAdvice {
/*
	@ExceptionHandler(value= RuntimeException.class)
	public ResponseEntity<ErrorDto> runtimeExceptionHandler(RuntimeException ex){
		ErrorDto error = new ErrorDto("P-500", ex.getMessage());
			return new ResponseEntity(error, HttpStatus.CONFLICT);
	}
	*/
	/*
	@ExceptionHandler(value= ExceptionGeneric.class)
	public ResponseEntity<ErrorDto> ExceptionGeneric(ExceptionGeneric ex){
		ErrorDto error = new ErrorDto(ex.getCode(), ex.getMessage());
			return new ResponseEntity(error, ex.getStatus());
	}
	*/
	@ExceptionHandler(value = ExceptionGeneric.class)
	public ResponseEntity<ErrorDto> handleExceptionGeneric(ExceptionGeneric ex) {
	    ErrorDto error = new ErrorDto(ex.getCode(), ex.getMessage());
	    return new ResponseEntity<>(error, ex.getStatus());
	}

}
