package com.api.pintureria.Pintureria.service;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.api.pintureria.Pintureria.model.PintureriaModel;
import com.api.pintureria.Pintureria.model.UsuarioModel;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service
//@RequiredArgsConstructor
public class JwtService  implements IJwtService{
	//@Value("${jwt.secret.key}")
	
	private String SECRET_KEY = "586E3272357538782F413F4428472B4B6250655368566B597033733676397924";
   

    public String getToken( PintureriaModel pintureria) {
        return getToken(new HashMap<>(), pintureria);
    }

    private String getToken(Map<String,Object> extraClaims, PintureriaModel pintureria) {
    	return Jwts.builder()
                .setSubject(pintureria.getUsername()) 
                .claim("id", pintureria.getId())
                .claim("nombre", pintureria.getNombre())
                .claim("direccion", pintureria.getDireccion())
                .claim("telefono", pintureria.getTelefono())/// Aquí se establece el nombre de usuario
                .setIssuedAt(new Date(System.currentTimeMillis()))  // Fecha de creación del token
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))  // Expiración a 10 horas
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)  // Clave secreta para firmar el token
                .compact();
    }

    private Key getKey() {
       byte[] keyBytes=Decoders.BASE64.decode(SECRET_KEY);
       return Keys.hmacShaKeyFor(keyBytes);
    }

   /* public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }*/
    public String getUsernameFromToken(String token) {
        String username = Jwts.parser()
                              .setSigningKey(SECRET_KEY)
                              .parseClaimsJws(token)
                              .getBody()
                              .getSubject();
        System.out.println("Extracted username from token: " + username);
        return username;
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username=getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }

    private Claims getAllClaims(String token)
    {
        return Jwts
            .parserBuilder()
            .setSigningKey(getKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    public <T> T getClaim(String token, Function<Claims,T> claimsResolver)
    {
        final Claims claims=getAllClaims(token);
        return claimsResolver.apply(claims);
    }
    
    private Date getExpiration(String token)
    {
        return getClaim(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token)
    { 
    	
        return getExpiration(token).before(new Date());
    }
}
