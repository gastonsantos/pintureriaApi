package com.api.pintureria.Pintureria.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.api.pintureria.Pintureria.repository.PintureriaRepository;
import com.api.pintureria.Pintureria.repository.ProductoRepository;
import com.api.pintureria.Pintureria.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UsuarioRepository userRepository;
    private final PintureriaRepository _pintureriaRepository;
    private final ProductoRepository _productoRepository;
    @Autowired
    public ApplicationConfig(UsuarioRepository userRepository, PintureriaRepository pintureriaRepository, ProductoRepository productoRepository) {
		this._pintureriaRepository = pintureriaRepository;
		this.userRepository = userRepository;
		this._productoRepository = productoRepository;
	}
    
    /*
     Cuando un método está anotado con @Bean, Spring lo ejecuta automáticamente al iniciar la aplicación 
     para crear una instancia del tipo de retorno del método.
     Esta instancia es gestionada por el contenedor de Spring.
     */
    
    /*
     * Este método define un bean de tipo AuthenticationManager, 
     * que es responsable de manejar el proceso de autenticación.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
    {
        return config.getAuthenticationManager();
    }

   
/*
 * Este método define un AuthenticationProvider,
   que es un componente encargado de procesar la autenticación de usuarios.
 */
	@Bean
    public AuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider authenticationProvider= new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /*
     * Este método define un UserDetailsService, que es utilizado para cargar los
     * detalles de un usuario durante la autenticación.
     */
    @Bean
    public UserDetailsService userDetailService() {
        return username -> _pintureriaRepository.findByUsername(username)
        .orElseThrow(()-> new UsernameNotFoundException("User not fournd"));
    }

}