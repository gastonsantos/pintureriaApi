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
	    
}
