package com.api.pintureria.Pintureria.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.pintureria.Pintureria.model.PintureriaModel;


@Repository
public interface PintureriaRepository extends JpaRepository<PintureriaModel, Long> {
	 Optional<PintureriaModel> findByUsername(String username);
	 public Optional<PintureriaModel> findById(Long id);
	 // Optional<PintureriaModel> findByUsernameAndPassword(String username, String password); 
	 public PintureriaModel findByUsernameAndPassword(String username, String password); 
}
