package com.api.pintureria.Pintureria.model;


import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Pintureria")
public class PintureriaModel {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column
	    private String nombre;

	    @Column
	    private String direccion;
	    
	    @Column 
	    private String telefono;
	    
	    @Column 
	    private String email; 
	    
	    @Column 
	    private String contrasenia;
	    
	    @OneToMany(mappedBy = "pintureria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private Set<StockPintureriaModel> stockPinturerias;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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

		public String getContrasenia() {
			return contrasenia;
		}

		public void setContrasenia(String contrasenia) {
			this.contrasenia = contrasenia;
		}

		public Set<StockPintureriaModel> getStockPinturerias() {
			return stockPinturerias;
		}

		public void setStockPinturerias(Set<StockPintureriaModel> stockPinturerias) {
			this.stockPinturerias = stockPinturerias;
		}
	    
}
