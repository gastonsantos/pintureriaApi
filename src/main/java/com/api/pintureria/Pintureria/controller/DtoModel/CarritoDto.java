package com.api.pintureria.Pintureria.controller.DtoModel;

public class CarritoDto {

	private Long cliente_id;
	private Long pintureria_id;
	
	
	public CarritoDto() {
		
	}
	public CarritoDto(Long cliente_id,Long pintureria_id) {
		super();
		this.cliente_id = cliente_id;
		
		this.pintureria_id = pintureria_id;
	}
	public Long getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Long cliente_id) {
		this.cliente_id = cliente_id;
	}
	
	public Long getPintureria_id() {
		return pintureria_id;
	}
	public void setPintureria_id(Long pintureria_id) {
		this.pintureria_id = pintureria_id;
	}
	
	
}
