package com.api.pintureria.Pintureria.model;

public class ProductoDto {
	private Long id;
    private String nombre;
    private Double precio;
    private Integer cantidad;
    private String descripcion;
    private String categoria;
    
    public ProductoDto() {
		
	}

    public ProductoDto( String nombre, Double precio, String descripcion, String categoria) {
        
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.categoria =categoria;
    }
    public ProductoDto( String nombre, Integer cantidad, Double precio, String descripcion, String categoria) {
        
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.categoria =categoria;
    }
 
	public ProductoDto(Long id, String nombre, Integer cantidad, Double precio, String descripcion, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.categoria =categoria;
    }

	public Integer getCantidad() {
        return cantidad; // Cambia a Integer
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public Double getPrecio() {
		return precio;
	}



	public void setPrecio(Double precio) {
		this.precio = precio;
	}



	// Getters y Setters
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

 
}
