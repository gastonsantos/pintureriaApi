package com.api.pintureria.Pintureria.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
 
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Aplica CORS a todas las rutas
        .allowedOrigins(
        	    "http://localhost:3000",
        	    "https://pintureria-front.vercel.app",
        	    "https://pintureria-front-b42wsuwca-gastonsantos-projects.vercel.app",
        	    "https://pintureria-front-olutiwsy9-gastonsantos-projects.vercel.app"
        	)

                //.allowedOrigins("https://pintureria-front.vercel.app","https://pintureria-front-h4nzs4zib-gastonsantos-projects.vercel.app")   
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Métodos HTTP permitidos
                .allowedHeaders("Content-Type", "Authorization")

                //.allowedHeaders("*") // Headers permitidos
                .allowCredentials(true); // Permitir credenciales (cookies, auth headers)
    } 
}
