package com.api.pintureria.Pintureria.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.api.pintureria.Pintureria.model.PintureriaModel;
import com.api.pintureria.Pintureria.model.UsuarioModel;

public interface IJwtService {
	 public String getToken(PintureriaModel pintureria);
	 public String getUsernameFromToken(String token);
	 public boolean isTokenValid(String token, UserDetails userDetails);
}
