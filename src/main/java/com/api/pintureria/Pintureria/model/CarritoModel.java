package com.api.pintureria.Pintureria.model;

import java.util.Date;
import java.util.Optional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Carrito")
public class CarritoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pintureria_id")
    private PintureriaModel pintureria;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private Double total;

    @Column
    private Boolean confirmada;

    
    
    public CarritoModel() {
		
	}

	public CarritoModel(Long id, ClienteModel cliente, PintureriaModel pintureria, Date fecha, Double total,
			Boolean confirmada) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.pintureria = pintureria;
		this.fecha = fecha;
		this.total = total;
		this.confirmada = confirmada;
	}

	// Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel clienteEncontrado) {
        this.cliente = clienteEncontrado;
    }

    public PintureriaModel getPintureria() {
        return pintureria;
    }

    public void setPintureria(PintureriaModel pintureriaEncontrada) {
        this.pintureria = pintureriaEncontrada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getConfirmada() {
        return confirmada;
    }

    public void setConfirmada(Boolean confirmada) {
        this.confirmada = confirmada;
    }

}
