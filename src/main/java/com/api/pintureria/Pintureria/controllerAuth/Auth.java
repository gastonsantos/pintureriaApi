package com.api.pintureria.Pintureria.controllerAuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.pintureria.Pintureria.service.AuthService;
import com.api.pintureria.Pintureria.service.IAuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")

public class Auth {
    
	 private final IAuthService _authService;
	    
	 
	 @Autowired
	    public Auth(IAuthService _authService) {
		
		this._authService = _authService;
	    }

		@PostMapping(value = "login")
	    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
	    {
	        return ResponseEntity.ok(_authService.login(request));
	    }

	    @PostMapping(value = "register")
	    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request)
	    {
	        return ResponseEntity.ok(_authService.register(request));
	    }
	    
	    @GetMapping(value="hello")
		public String hello() {
		  return "La concha puta de tu madre";
	    } 
		  
}