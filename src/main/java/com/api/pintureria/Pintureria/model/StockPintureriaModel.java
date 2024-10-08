package com.api.pintureria.Pintureria.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "Stock_pintureria", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"pintureria_id", "producto_id"})
})
public class StockPintureriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_id", nullable = false)
    private ProductoModel producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pintureria_id", nullable = false)
    private PintureriaModel pintureria;

    @Column(nullable = false)
    private int cantidad;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ProductoModel getProducto() {
		return producto;
	}

	public void setProducto(ProductoModel producto) {
		this.producto = producto;
	}

	public PintureriaModel getPintureria() {
		return pintureria;
	}

	public void setPintureria(PintureriaModel pintureria) {
		this.pintureria = pintureria;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

    

}
