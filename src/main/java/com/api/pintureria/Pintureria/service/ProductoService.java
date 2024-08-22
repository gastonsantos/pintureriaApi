package com.api.pintureria.Pintureria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.pintureria.Pintureria.model.ProductoModel;
import com.api.pintureria.Pintureria.repository.ProductoRepository;

@Service
public class ProductoService implements IProductoService{
	  @Autowired
	   private ProductoRepository productoRepository;
	  
	  @Override
	  public List<ProductoModel> findAllProductosModel() {
		return productoRepository.findAll();
	}
	
}
