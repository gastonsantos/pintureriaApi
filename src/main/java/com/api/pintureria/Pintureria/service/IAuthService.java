package com.api.pintureria.Pintureria.service;

import com.api.pintureria.Pintureria.controllerAuth.AuthResponse;
import com.api.pintureria.Pintureria.controllerAuth.LoginRequest;
import com.api.pintureria.Pintureria.controllerAuth.RegisterRequest;

public interface IAuthService {

	public AuthResponse login(LoginRequest request);
 //   public AuthResponse register(RegisterRequest request);
 
}
