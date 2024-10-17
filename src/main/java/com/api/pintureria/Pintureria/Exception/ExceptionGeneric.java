package com.api.pintureria.Pintureria.Exception;

import org.springframework.http.HttpStatus;
//RuntimeException son excepciones que pasan en tiempo de ejecucion.
public class ExceptionGeneric extends RuntimeException{

	private String code;
	private String message;
	private HttpStatus status;
	
	
	public ExceptionGeneric(String code, String message, HttpStatus status) {
		super();
		this.code = code;
		this.message = message;
		this.status = status;
	}
	public ExceptionGeneric() {
	
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	
}
