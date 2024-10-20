package com.api.pintureria.Pintureria.controller.DtoModel;

public class ClienteDto {

	private Integer dni;
	private String nombre;
	private String direccion;
	private String telefono;
	private String email;
	
	
	public ClienteDto(Integer dni) {
		
		this.dni = dni;
	}
	public ClienteDto() {
		
	}
	public ClienteDto(Integer dni, String nombre, String direccion, String telefono, String email) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
