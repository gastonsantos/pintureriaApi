package com.api.pintureria.Pintureria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import com.api.pintureria.Pintureria.controllerAuth.AuthResponse;
import com.api.pintureria.Pintureria.controllerAuth.LoginRequest;
import com.api.pintureria.Pintureria.controllerAuth.RegisterRequest;
import com.api.pintureria.Pintureria.model.UsuarioModel;
import com.api.pintureria.Pintureria.repository.UsuarioRepository;

import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.RequiredArgsConstructor;

@Service
public class AuthService implements IAuthService {

    private final UsuarioRepository _usuarioRepository;
    private final IJwtService _jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager autenticationManager;

    @Autowired
    public AuthService(UsuarioRepository _usuarioRepository, 
                       IJwtService _jwtService, 
                       PasswordEncoder passwordEncoder, 
                       AuthenticationManager autenticationManager) {
        this._usuarioRepository = _usuarioRepository;
        this._jwtService = _jwtService;
        this.passwordEncoder = passwordEncoder;
        this.autenticationManager = autenticationManager;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        //autenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = _usuarioRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword()).orElseThrow();
     
       
        System.out.println("En el login:  " + user.getUsername()+" ,"+user.getPassword());
        String token = _jwtService.getToken(user);
        AuthResponse authResponse = new AuthResponse();  
        authResponse.setToken(token);
        return authResponse;
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        UsuarioModel user = new UsuarioModel();
        user.setUsername(request.getUsername());
        //user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setCountry(request.getCountry());
        _usuarioRepository.save(user);
        AuthResponse authResponse = new AuthResponse();  
        authResponse.setToken(_jwtService.getToken(user));
        return authResponse;
    }

	
	
}
