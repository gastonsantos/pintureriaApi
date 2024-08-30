package com.api.pintureria.Pintureria.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.api.pintureria.Pintureria.service.JwtService;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFiltrer extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserDetailsService userDetailsService;


    /*
     doFilterInternal: Este metodo se ejecuta en cada solicitur HTTP. Es el responsable de extraer el token de la Cabecera, 
     validarlo y autenticar al usuario si es todo correcto.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
    	//obtiene el valor de la cabecera: Autherization que por lo general esta ahi el JWT
        final String authHeader = request.getHeader("Authorization"); 
        final String jwt;
        final String username;
        
        if (authHeader == null || !authHeader.startsWith("Bearer ")) { // si es nulo o no comienza con Bearer: 
        	//Si no tiene cabecera o no tiene Authrozation Bearer: 
        	System.out.println("Entra aca y sale");
            filterChain.doFilter(request, response); //Permite que le ejecucion pase y no haga mas nada
            return; // retorna.
        }
     // si no es nulo o comienza con Bearer, obtiene el token, eliminando los primeros 7 caracteres de la cabecera Auttherization
        jwt = authHeader.substring(7); 
        
        
        // Extraer el nombre de usuario del token del Servicio jwtService
        username = jwtService.getUsernameFromToken(jwt);
        //Verifica la Autenticacion actual 
        //Si se obtuvo un nombre de usuario en el Token, y no hay una Authenticacion en el contexto de seguridad.
        // se va a buscar a la base de datos, los datos del Usuario
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            //Verifico si el token es valido.
            if (jwtService.isTokenValid(jwt, userDetails)) {
            	// si es valido, se crea un objeto: UsernamePasswordAuthenticationToken
            	
            	/*
            	 * UsernamePasswordAuthenticationToken es una implementación de Authentication que representa un token
            	 *  para la autenticación con un nombre de usuario, contraseñas y roles asociados.
            	 */
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                userDetails, null, /*userDetails.getAuthorities()*/ null);
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        
        filterChain.doFilter(request, response);
    }



}

