package com.api.pintureria.Pintureria.Exception;

import org.springframework.http.HttpStatus;

public class UsuarioNoPuedeSerVacioException extends ExceptionGeneric{

	public UsuarioNoPuedeSerVacioException() {
		
		this.setCode(CodigosError.USUARIO_VACIO.getCode());
		this.setMessage(CodigosError.USUARIO_VACIO.getMessage());
		this.setStatus(CodigosError.USUARIO_VACIO.getHttp());
	}
	

}
