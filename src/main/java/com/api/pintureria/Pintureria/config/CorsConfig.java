package com.api.pintureria.Pintureria.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
 
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	    registry.addMapping("/**")
	            .allowedOrigins(
	                "http://localhost:3000",
	                "https://pintureria-front.vercel.app",
	                "https://pintureria-front-b42wsuwca-gastonsantos-projects.vercel.app",
	                "https://pintureria-front-olutiwsy9-gastonsantos-projects.vercel.app"
	            )
	            .allowedMethods("GET", "POST", "PUT", "DELETE")
	            .allowedHeaders("Content-Type", "Authorization", "Access-Control-Allow-Origin")
	            .allowCredentials(true);
	}

}
