package com.api.pintureria.Pintureria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.pintureria.Pintureria.model.PintureriaModel;
import com.api.pintureria.Pintureria.model.ProductoModel;



@Repository
public interface ProductoRepository extends  JpaRepository<ProductoModel, Long>{

	//public Optional<ProductoModel> findById(Long id);
	
}
