package com.api.pintureria.Pintureria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.pintureria.Pintureria.model.ProductoModel;
import com.api.pintureria.Pintureria.service.IProductoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductoController {
	
	@Autowired
	private IProductoService _productoServices;
	 

	public ProductoController(IProductoService _productoServices) {
		
		this._productoServices = _productoServices;
	}

	@GetMapping(value="hello")
	public String hello() {
	  return "La concha puta de tu madre";
	}
	
	@GetMapping(value="todosLosProductos")
	public List<ProductoModel> allProductos(){
		return _productoServices.findAllProductosModel();
	}
}
