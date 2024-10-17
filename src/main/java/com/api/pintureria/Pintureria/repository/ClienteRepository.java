package com.api.pintureria.Pintureria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.pintureria.Pintureria.model.ClienteModel;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

	public ClienteModel findByDni(Integer dni);
}
