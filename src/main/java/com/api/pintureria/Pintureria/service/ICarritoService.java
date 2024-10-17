package com.api.pintureria.Pintureria.service;

import com.api.pintureria.Pintureria.controller.DtoModel.CarritoDto;
import com.api.pintureria.Pintureria.controller.DtoModel.ClienteDto;
import com.api.pintureria.Pintureria.model.CarritoModel;
import com.api.pintureria.Pintureria.model.ClienteModel;

public interface ICarritoService {
	public CarritoModel createCarritoModel(CarritoDto carritoDto);
	public void createClienteModel(ClienteDto clienteDto);
	public ClienteModel buscarClienteModelByDni(Integer dni);
}
