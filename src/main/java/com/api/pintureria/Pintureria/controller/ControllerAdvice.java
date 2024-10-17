package com.api.pintureria.Pintureria.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.api.pintureria.Pintureria.Exception.*;
import com.api.pintureria.Pintureria.model.ErrorDto;

@RestControllerAdvice
public class ControllerAdvice {

	// Lo que hace el RescControllerAdvance es que cuando se genera un excepcion es lo que se devuelve.
	@ExceptionHandler(value = ExceptionGeneric.class)
	public ResponseEntity<ErrorDto> handleExceptionGeneric(ExceptionGeneric ex) {
	    ErrorDto error = new ErrorDto(ex.getCode(), ex.getMessage());
	    return new ResponseEntity<>(error, ex.getStatus());
	}

}
