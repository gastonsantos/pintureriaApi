package com.api.pintureria.Pintureria.Exception;

import org.springframework.http.HttpStatus;

public class PasswordNoPuedeSerVacioException  extends ExceptionGeneric{
	public PasswordNoPuedeSerVacioException() {
		
		this.setCode(CodigosError.PASSWORD_VACIO.getCode());
		this.setMessage(CodigosError.PASSWORD_VACIO.getMessage());
		this.setStatus(CodigosError.PASSWORD_VACIO.getHttp());
	}
}

