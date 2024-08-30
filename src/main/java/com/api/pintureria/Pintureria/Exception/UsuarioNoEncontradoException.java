package com.api.pintureria.Pintureria.Exception;

import org.springframework.http.HttpStatus;

public class UsuarioNoEncontradoException extends ExceptionGeneric{

public UsuarioNoEncontradoException() {
		
		this.setCode(CodigosError.USUARIO_O_CONTRASEÑA_INCORRECTOS.getCode());
		this.setMessage(CodigosError.USUARIO_O_CONTRASEÑA_INCORRECTOS.getMessage());
		this.setStatus(CodigosError.USUARIO_O_CONTRASEÑA_INCORRECTOS.getHttp());
	}
}
