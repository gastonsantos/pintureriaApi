package com.api.pintureria.Pintureria.model;

import java.util.Date;
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
@Table(name = "Producto")
public class ProductoModel {
	
	
	public ProductoModel() {
	}
	public ProductoModel(Long id, String nombre, String descripcion, Double precio, Integer stock, Date fecha_ingreso,
	Set<StockPintureriaModel> stockPinturerias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.fecha_ingreso = fecha_ingreso;
		this.stockPinturerias = stockPinturerias;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String descripcion;
     
   

	@Column 
    private Double precio;
    
    @Column 
    private Integer stock; 
    
    @Column 
    private Date fecha_ingreso;
    
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Set<StockPintureriaModel> getStockPinturerias() {
		return stockPinturerias;
	}

	public void setStockPinturerias(Set<StockPintureriaModel> stockPinturerias) {
		this.stockPinturerias = stockPinturerias;
	}

	
}
