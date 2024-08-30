package com.api.pintureria.Pintureria.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.api.pintureria.Pintureria.model.PintureriaModel;



public interface PintureriaRepository extends JpaRepository<PintureriaModel, Long> {
	 Optional<PintureriaModel> findByUsername(String username); 
	// Optional<PintureriaModel> findByUsernameAndPassword(String username, String password); 
	public PintureriaModel findByUsernameAndPassword(String username, String password); 
}
