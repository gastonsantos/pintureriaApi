package com.api.pintureria.Pintureria.Exception;

public class ProductoNoEncontradoException extends ExceptionGeneric{

public ProductoNoEncontradoException() {
		
		this.setCode(CodigosError.USUARIO_O_CONTRASEÑA_INCORRECTOS.getCode());
		this.setMessage(CodigosError.USUARIO_O_CONTRASEÑA_INCORRECTOS.getMessage());
		this.setStatus(CodigosError.USUARIO_O_CONTRASEÑA_INCORRECTOS.getHttp());
	}
}
