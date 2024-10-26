package com.api.pintureria.Pintureria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.pintureria.Pintureria.controller.DtoModel.CarritoDto;
import com.api.pintureria.Pintureria.controller.DtoModel.ClienteDto;
import com.api.pintureria.Pintureria.model.CarritoModel;
import com.api.pintureria.Pintureria.model.ClienteModel;
import com.api.pintureria.Pintureria.service.ICarritoService;
import com.api.pintureria.Pintureria.service.IPintureriaService;
import com.api.pintureria.Pintureria.service.IProductoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
//@RequiredArgsConstructor
public class CompraController {

	@Autowired
	private IPintureriaService _pintureriaService; 
	private ICarritoService _carritoService;
	public CompraController(IPintureriaService pintureriaService, ICarritoService carritoService) {
		this._carritoService = carritoService;
		this._pintureriaService = pintureriaService;
	}
	
	/*
	@GetMapping(value="hello1")
	public String hello() {
	  return "La concha puta de tu madre";
	}*/
	@PostMapping(value="buscarClientePorDni")
	public ClienteModel buscarCliente(@RequestBody ClienteDto cliente ){
		return _carritoService.buscarClienteModelByDni(cliente.getDni());
	}
	@PostMapping(value="crearCliente")
	public void crearCliente(@RequestBody ClienteDto cliente ){
		_carritoService.createClienteModel(cliente);
	}
	
	@PostMapping(value="crearCarrito")
	public CarritoModel crearCarrito(@RequestBody CarritoDto carrito ){
		return _carritoService.createCarritoModel(carrito);
	}
}
