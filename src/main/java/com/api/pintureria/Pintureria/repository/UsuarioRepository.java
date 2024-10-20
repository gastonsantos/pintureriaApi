package com.api.pintureria.Pintureria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.pintureria.Pintureria.model.UsuarioModel;
@Repository
public interface UsuarioRepository  extends  JpaRepository<UsuarioModel, Long> {
	 Optional<UsuarioModel> findByUsername(String username); 
	 Optional<UsuarioModel> findByUsernameAndPassword(String username, String password); 
}
