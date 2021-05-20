package com.komeya.jpa.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producto_x_reserva")
public class ProductoXReserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_Id", unique = true, nullable = false)
	private Long id;
	@Column(name = "FK_IdProducto", nullable = false)
	private Long idProducto;
	@Column(name = "FK_IdReserva", nullable = false)
	private Long idReserva;
	private Long cantidad;
	private Long precioXCantidad;
	
	
	
	public ProductoXReserva() {
		super();
	}
	public ProductoXReserva(Long id, Long idProducto, Long idReserva, Long cantidad, Long precioXCantidad) {
		super();
		this.id = id;
		this.idProducto = idProducto;
		this.idReserva = idReserva;
		this.cantidad = cantidad;
		this.precioXCantidad = precioXCantidad;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public Long getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
	public Long getPrecioXCantidad() {
		return precioXCantidad;
	}
	public void setPrecioXCantidad(Long precioXCantidad) {
		this.precioXCantidad = precioXCantidad;
	}
	
	
	
}
