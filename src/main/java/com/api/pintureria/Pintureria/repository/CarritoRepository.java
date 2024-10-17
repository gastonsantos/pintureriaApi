package com.api.pintureria.Pintureria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.pintureria.Pintureria.model.CarritoModel;


@Repository
public interface CarritoRepository extends JpaRepository<CarritoModel, Long> {

	
}
