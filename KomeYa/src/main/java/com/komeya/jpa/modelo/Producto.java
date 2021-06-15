package com.komeya.jpa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Esta clase es la entidad de producto cuyos atributos serviran para almacenar
 * dados en la base de datos.
 * 
 * @author Dani Kuradchyk
 */
@Entity
@Table(name = "producto")
public class Producto {

	/** id autoincrementable de los productos */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** El nombre del producto. */
	@Size(max = 240)
	@Pattern(regexp = "^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.\\'-]+$",
	message = "El nombre es incorrecto.")
	private String nombre;

	/** La descripcion del producto */
	@Size(max = 240)
	@Pattern(regexp = "^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.\\'-]+$",
	message = "La descripccion  es incorrecta.")
	private String descripcion;

	/** El tipo del producto */
	@Size(max = 240)
	@Pattern(regexp = "^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.\\'-]+$",
	message = "El tipo de producto es incorrecto.")
	private String tipoProducto;

	/** la url de la imagen del producto */
	private String imagenProducto;

	/** el campo de disponibilidad del producto */
	private boolean disponible;

	/** El precio del producto */
	@Min(0)
	@Max(999999)
	public Double precio;

	/**
	 * Instantiates a new producto.
	 */
	public Producto() {
		super();
	}

	/**
	 * Instantiates a new producto.
	 *
	 * @param id             the id
	 * @param nombre         the nombre
	 * @param descripcion    the descripcion
	 * @param tipoProducto   the tipo producto
	 * @param imagenProducto the imagen producto
	 * @param disponible     the disponible
	 * @param precio         the precio
	 */
	public Producto(Long id, String nombre, String descripcion, String tipoProducto, String imagenProducto,
			boolean disponible, Double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipoProducto = tipoProducto;
		this.imagenProducto = imagenProducto;
		this.disponible = disponible;
		this.precio = precio;
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
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the descripcion.
	 *
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Sets the descripcion.
	 *
	 * @param descripcion the new descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Gets the tipo producto.
	 *
	 * @return the tipo producto
	 */
	public String getTipoProducto() {
		return tipoProducto;
	}

	/**
	 * Sets the tipo producto.
	 *
	 * @param tipoProducto the new tipo producto
	 */
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	/**
	 * Gets the imagen producto.
	 *
	 * @return the imagen producto
	 */
	public String getImagenProducto() {
		return imagenProducto;
	}

	/**
	 * Sets the imagen producto.
	 *
	 * @param imagenProducto the new imagen producto
	 */
	public void setImagenProducto(String imagenProducto) {
		this.imagenProducto = imagenProducto;
	}

	/**
	 * Checks if is disponible.
	 *
	 * @return true, if is disponible
	 */
	public boolean isDisponible() {
		return disponible;
	}

	/**
	 * Sets the disponible.
	 *
	 * @param disponible the new disponible
	 */
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	/**
	 * Gets the precio.
	 *
	 * @return the precio
	 */
	public Double getPrecio() {
		return precio;
	}

	/**
	 * Sets the precio.
	 *
	 * @param precio the new precio
	 */
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
