package com.api.pintureria.Pintureria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.api.pintureria.Pintureria.jwt.JwtAuthenticationFiltrer;

import lombok.RequiredArgsConstructor;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	  private final JwtAuthenticationFiltrer jwtAuthenticationFilter;
	    private final AuthenticationProvider authProvider;
	
	    
	  public SecurityConfig(JwtAuthenticationFiltrer jwtAuthenticationFilter, AuthenticationProvider authProvider) {
			
			this.jwtAuthenticationFilter = jwtAuthenticationFilter;
			this.authProvider = authProvider;
		}


	@Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	    {
		  //Va a retornar la peticion http siempre y cuando pase por los filtros que configuramos
	        return http
	            .csrf(csrf ->  
	                csrf
	                .disable()) // se Deshabilita la proteccion CSRF, que viene por defecto porque vamos a usar JWT, creado por nosotros.
	            .authorizeHttpRequests(authRequest ->
	              authRequest
	                .requestMatchers("/auth/**").permitAll()
	                .anyRequest().authenticated() // Toda el resto de Request se va a pedir que esten autenticadas.
	                )
	            .sessionManagement(sessionManager->
                sessionManager 
                  .sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //Lo que hace es deshabilitar las sesiones
            .authenticationProvider(authProvider)
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) //Añade un filtro que es el jwtAuthenticationFiltrer,
            //antes del de Username y Password
            .build();
	            
	    }


}
