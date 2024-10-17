package com.api.pintureria.Pintureria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;

import com.api.pintureria.Pintureria.Exception.ExceptionGeneric;
import com.api.pintureria.Pintureria.Exception.PasswordNoPuedeSerVacioException;
import com.api.pintureria.Pintureria.Exception.UsuarioNoEncontradoException;
import com.api.pintureria.Pintureria.Exception.UsuarioNoPuedeSerVacioException;
import com.api.pintureria.Pintureria.controllerAuth.AuthResponse;
import com.api.pintureria.Pintureria.controllerAuth.LoginRequest;
import com.api.pintureria.Pintureria.controllerAuth.RegisterRequest;
import com.api.pintureria.Pintureria.model.PintureriaModel;
import com.api.pintureria.Pintureria.model.UsuarioModel;
import com.api.pintureria.Pintureria.repository.PintureriaRepository;
import com.api.pintureria.Pintureria.repository.UsuarioRepository;


import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.RequiredArgsConstructor;

@Service
public class AuthService implements IAuthService {

    private final UsuarioRepository _usuarioRepository;
    private final PintureriaRepository _pintureriaRepository;
    private final IJwtService _jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager autenticationManager;

    @Autowired
    public AuthService(UsuarioRepository _usuarioRepository, 
                       IJwtService _jwtService, 
                       PasswordEncoder passwordEncoder, 
                       AuthenticationManager autenticationManager, 
                       PintureriaRepository pintureriaRepository) {
        this._usuarioRepository = _usuarioRepository;
        this._jwtService = _jwtService;
        this.passwordEncoder = passwordEncoder;
        this.autenticationManager = autenticationManager;
        this._pintureriaRepository = pintureriaRepository;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        //autenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        //UserDetails user = _usuarioRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword()).orElseThrow();
    	   if(request.getPassword().equals(null) || request.getPassword().isEmpty() || request.getPassword().isBlank() ) {
        	   //throw new ExceptionGeneric("P-506", "El Password no puede ser vacio", HttpStatus.BAD_REQUEST);
    		   
    		   throw new PasswordNoPuedeSerVacioException();
           }if(request.getUsername().equals(null) || request.getUsername().isEmpty() || request.getUsername().isBlank()){
        	   
        	   throw new UsuarioNoPuedeSerVacioException();
           }
    	UserDetails user = _pintureriaRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
    	PintureriaModel pintureria = _pintureriaRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
    		if(user == null || pintureria == null ) {
    			 throw new UsuarioNoEncontradoException();
    		}
        System.out.println("En el login:  " + user.getUsername()+" ,"+user.getPassword());
        String token = _jwtService.getToken(pintureria);
        AuthResponse authResponse = new AuthResponse();  
        authResponse.setToken(token);
        return authResponse;
    }
/*
    @Override
    public AuthResponse register(RegisterRequest request) {
        PintureriaModel pintureria = new PintureriaModel();
        pintureria.setUsername(request.getUsername());
        //user.setPassword(passwordEncoder.encode(request.getPassword()));
        pintureria.setPassword(request.getPassword());
        pintureria.setDireccion(request.getFirstname());
        pintureria.setTelefono(request.getLastname());
       
        _pintureriaRepository.save(pintureria);
        AuthResponse authResponse = new AuthResponse();  
        authResponse.setToken(_jwtService.getToken(pintureria));
        return authResponse;
    }

	*/
	
}
