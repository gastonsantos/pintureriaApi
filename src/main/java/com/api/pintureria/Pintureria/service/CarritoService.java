package com.api.pintureria.Pintureria.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.pintureria.Pintureria.controller.DtoModel.CarritoDto;
import com.api.pintureria.Pintureria.controller.DtoModel.ClienteDto;
import com.api.pintureria.Pintureria.model.CarritoModel;
import com.api.pintureria.Pintureria.model.ClienteModel;
import com.api.pintureria.Pintureria.model.PintureriaModel;
import com.api.pintureria.Pintureria.model.ProductoModel;
import com.api.pintureria.Pintureria.repository.CarritoRepository;
import com.api.pintureria.Pintureria.repository.ClienteRepository;
import com.api.pintureria.Pintureria.repository.PintureriaRepository;
import com.api.pintureria.Pintureria.repository.ProductoRepository;

@Service
public class CarritoService implements ICarritoService{

	  @Autowired
	   private CarritoRepository carritoRepository;
	   private PintureriaRepository pintureriaRepository;
	   private ClienteRepository clienteRepository;
	   
	   public CarritoService(CarritoRepository carritoRepository,PintureriaRepository pintureriaRepository, ClienteRepository clienteRepository ) {
		 this.clienteRepository = clienteRepository;
		this.carritoRepository = carritoRepository;
		this.pintureriaRepository = pintureriaRepository;
	}
	  @Override
	  public void createClienteModel(ClienteDto clienteDto) {
		  
		 ClienteModel clienteModel= new ClienteModel();
		 clienteModel.setNombre(clienteDto.getNombre());
		 clienteModel.setDireccion(clienteDto.getDireccion());
		 clienteModel.setDni(clienteDto.getDni());
		 clienteModel.setEmail(clienteDto.getEmail());
		 clienteModel.setTelefono(clienteDto.getTelefono());
		 clienteRepository.save(clienteModel);
	   }
	  
	  @Override
	  public ClienteModel buscarClienteModelByDni(Integer dni) {
		  
		  return clienteRepository.findByDni(dni);
	  }
	  
	  @Override
	  public CarritoModel createCarritoModel(CarritoDto carritoDto) {
		  
		  PintureriaModel pintureriaEncontrada = pintureriaRepository.findById(carritoDto.getPintureria_id()).orElseThrow(); 
		  ClienteModel clienteEncontrado = clienteRepository.findById(carritoDto.getCliente_id()).orElseThrow();
		  
		  if(pintureriaEncontrada.equals(null)) {
			  return null;
		  }
		  if(clienteEncontrado.equals(null)) {
			  return null;
			  
		  }
		  CarritoModel carrito = new CarritoModel();
		  carrito.setPintureria(pintureriaEncontrada);
		  carrito.setCliente(clienteEncontrado);
		  carrito.setConfirmada(false);
		  carrito.setFecha(new Date());
		  carrito.setTotal(0.0);
		  
		return carritoRepository.save(carrito);
	}
	
	  
	
	  
	  
	
	
}
