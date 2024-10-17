package com.api.pintureria.Pintureria.Exception;

import org.springframework.http.HttpStatus;

public enum CodigosError {
	
	    USUARIO_VACIO("P-503", "El Usuario no puede ser vacio", HttpStatus.UNAUTHORIZED),
	    PASSWORD_VACIO("P-506", "El Password no puede ser vacio", HttpStatus.CONFLICT),
	    USUARIO_O_CONTRASEÑA_INCORRECTOS("P-502", "El Usuario o Contraseña son incorrectos", HttpStatus.BAD_REQUEST),
		EL_USUARIO_YA_ESXISTE("P-200", "El usuario ya existe", HttpStatus.BAD_REQUEST);
		/*PRODUCTO_NO_ENCONTRADO("P-201", "Producto no encontrado", HttpStatus.CONTINUE	)*/
	
	    private final String code;
	    private final String message;
	    private final HttpStatus http;

	    CodigosError(String code, String message,HttpStatus http) {
	        this.code = code;
	        this.message = message;
	        this.http = http;
	    }

	    public String getCode() {
	        return code;
	    }

	    public String getMessage() {
	        return message;
	    }

		public HttpStatus getHttp() {
			return http;
		}
	    
	
}
