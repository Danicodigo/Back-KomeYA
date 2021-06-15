package com.komeya.jpa.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Esta clase es la entidad de la relacion entre productos y reservas cuyos
 * atributos serviran para almacenar dados en la base de datos.
 * 
 * @author Dani Kuradchyk
 */
@Entity
@Table(name = "producto_x_reserva")
public class ProductoXReserva {

	/** El id de la relacion. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_Id", unique = true, nullable = false)
	private Long id;

	/** Id del producto */
	@Column(name = "FK_IdProducto", nullable = false)
	private Long idProducto;

	/** El id de la reserva */
	@Column(name = "FK_IdReserva", nullable = false)
	private Long idReserva;

	/** La cantidad de los productos de la reserva */
	@Min(0)
	@Max(999999)
	private Long cantidad;

	/** El precio total de la relacion */
	@Min(0)
	@Max(999999)
	private Long precioXCantidad;

	/**
	 * Instantiates a new producto X reserva.
	 */
	public ProductoXReserva() {
		super();
	}

	/**
	 * Instantiates a new producto X reserva.
	 *
	 * @param id              the id
	 * @param idProducto      the id producto
	 * @param idReserva       the id reserva
	 * @param cantidad        the cantidad
	 * @param precioXCantidad the precio X cantidad
	 */
	public ProductoXReserva(Long id, Long idProducto, Long idReserva, Long cantidad, Long precioXCantidad) {
		super();
		this.id = id;
		this.idProducto = idProducto;
		this.idReserva = idReserva;
		this.cantidad = cantidad;
		this.precioXCantidad = precioXCantidad;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the id producto.
	 *
	 * @return the id producto
	 */
	public Long getIdProducto() {
		return idProducto;
	}

	/**
	 * Sets the id producto.
	 *
	 * @param idProducto the new id producto
	 */
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	/**
	 * Gets the id reserva.
	 *
	 * @return the id reserva
	 */
	public Long getIdReserva() {
		return idReserva;
	}

	/**
	 * Sets the id reserva.
	 *
	 * @param idReserva the new id reserva
	 */
	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	/**
	 * Gets the cantidad.
	 *
	 * @return the cantidad
	 */
	public Long getCantidad() {
		return cantidad;
	}

	/**
	 * Sets the cantidad.
	 *
	 * @param cantidad the new cantidad
	 */
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Gets the precio X cantidad.
	 *
	 * @return the precio X cantidad
	 */
	public Long getPrecioXCantidad() {
		return precioXCantidad;
	}

	/**
	 * Sets the precio X cantidad.
	 *
	 * @param precioXCantidad the new precio X cantidad
	 */
	public void setPrecioXCantidad(Long precioXCantidad) {
		this.precioXCantidad = precioXCantidad;
	}

}
