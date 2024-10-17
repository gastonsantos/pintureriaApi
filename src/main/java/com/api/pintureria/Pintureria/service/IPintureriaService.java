package com.api.pintureria.Pintureria.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.api.pintureria.Pintureria.model.ProductoDto;
import com.api.pintureria.Pintureria.model.ProductoModel;

public interface IPintureriaService {

	List<ProductoDto> findProductosAndCantidadByPintureriaId( Long pintureriaId);
	public ProductoDto productoPorId(Long productoId);
}
