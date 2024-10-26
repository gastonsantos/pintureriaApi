package com.api.pintureria.Pintureria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.pintureria.Pintureria.controller.DtoModel.IdRequest;
import com.api.pintureria.Pintureria.model.ProductoDto;
import com.api.pintureria.Pintureria.model.ProductoModel;
import com.api.pintureria.Pintureria.service.IPintureriaService;
import com.api.pintureria.Pintureria.service.IProductoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
//@RequiredArgsConstructor
public class ProductoController {
	
	@Autowired
	private IProductoService _productoServices;
	private IPintureriaService _pintureriaService; 

	public ProductoController(IProductoService _productoServices, IPintureriaService pintureriaService) {
		
		this._productoServices = _productoServices;
		this._pintureriaService = pintureriaService;
	}
	/*
	@GetMapping(value="hello")
	public String hello() {
	  return "La concha puta de tu madre";
	}
	*/
	@GetMapping(value="todosLosProductos")
	public List<ProductoModel> allProductos(){
		return _productoServices.findAllProductosModel();
	}
	
	@PostMapping(value="todosLosProductosPorPintureria")
	public List<ProductoDto> allProductosPorPintureria (@RequestBody IdRequest idRequest){
		return _pintureriaService.findProductosAndCantidadByPintureriaId(idRequest.getId());
	}
	
	
	@PostMapping(value="productoPorId")
	public ProductoDto obtenerProductoDtoPorId(@RequestBody IdRequest idRequest) {
		return _productoServices.retornaProductoParaEndPoing(idRequest.getId());
	}
	@PostMapping(value="productoModelPorId")
	public ProductoModel obtenerProductoModelPorId(@RequestBody IdRequest idRequest) {
		return _productoServices.findProductoById(idRequest.getId());
	}
	@PostMapping(value="productoModelPorIdDos")
	public String obtenerNombreProductoModelPorId(@RequestBody IdRequest idRequest) {
		return _productoServices.retornaProductoParaEndPoint(idRequest.getId());
	}
	
	@PostMapping(value="guardarCambios")
	public boolean guardarCambiosDeProducto(@RequestBody ProductoDto producto) {
		return _productoServices.modificarProducto(producto);
	}
	
	@PostMapping(value="agregarProducto")
	public void agregarProducto(@RequestBody ProductoDto producto) {
		 _productoServices.agregarStockProductoPintureria(producto);
	}

}