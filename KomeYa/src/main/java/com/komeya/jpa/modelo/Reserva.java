package com.komeya.jpa.modelo;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Esta clase es la entidad de reserva cuyos atributos serviran para almacenad
 * dados en la base de datos.
 * 
 * @author Dani Kuradchyk
 */
@Entity
@Table(name = "reserva")
public class Reserva {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_Id", unique = true, nullable = false)
	private Long id;

	/** The fecha. */
	@Size(max = 240)
	private Date fecha;

	/** The hora. */
	@Size(max = 240)
	private Time hora;

	/** The tipo reserva. */
	@Size(max = 240)
	@Pattern(regexp = "^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.\\'-]+$", message = "El tipo de producto es incorrecto.")
	private String tipoReserva;

	/** The num personas. */
	@Size(max = 240)
	private Integer numPersonas;

	/** The sugerencias. */
	@Size(max = 240)
	private String sugerencias;

	/** The id usuario. */
	@Size(max = 240)
	private Long idUsuario;

	/** The estado. */
	@Size(max = 240)
	@Pattern(regexp = "^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.\\'-]+$", message = "El estado es incorrecto.")
	private String estado;

	/**
	 * Instantiates a new reserva.
	 *
	 * @param id          the id
	 * @param fecha       the fecha
	 * @param hora        the hora
	 * @param tipoReserva the tipo reserva
	 * @param numPersonas the num personas
	 * @param sugerencias the sugerencias
	 * @param idUsuario   the id usuario
	 * @param estado      the estado
	 */
	public Reserva(Long id, Date fecha, Time hora, String tipoReserva, Integer numPersonas, String sugerencias,
			Long idUsuario, String estado) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.tipoReserva = tipoReserva;
		this.numPersonas = numPersonas;
		this.sugerencias = sugerencias;
		this.idUsuario = idUsuario;
		this.estado = estado;
	}

	/**
	 * Instantiates a new reserva.
	 */
	public Reserva() {
		super();
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
	 * Gets the fecha.
	 *
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Sets the fecha.
	 *
	 * @param fecha the new fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Gets the hora.
	 *
	 * @return the hora
	 */
	public Time getHora() {
		return hora;
	}

	/**
	 * Sets the hora.
	 *
	 * @param hora the new hora
	 */
	public void setHora(Time hora) {
		this.hora = hora;
	}

	/**
	 * Gets the tipo reserva.
	 *
	 * @return the tipo reserva
	 */
	public String getTipoReserva() {
		return tipoReserva;
	}

	/**
	 * Sets the tipo reserva.
	 *
	 * @param tipoReserva the new tipo reserva
	 */
	public void setTipoReserva(String tipoReserva) {
		this.tipoReserva = tipoReserva;
	}

	/**
	 * Gets the num personas.
	 *
	 * @return the num personas
	 */
	public Integer getNumPersonas() {
		return numPersonas;
	}

	/**
	 * Sets the num personas.
	 *
	 * @param numPersonas the new num personas
	 */
	public void setNumPersonas(Integer numPersonas) {
		this.numPersonas = numPersonas;
	}

	/**
	 * Gets the sugerencias.
	 *
	 * @return the sugerencias
	 */
	public String getSugerencias() {
		return sugerencias;
	}

	/**
	 * Sets the sugerencias.
	 *
	 * @param sugerencias the new sugerencias
	 */
	public void setSugerencias(String sugerencias) {
		this.sugerencias = sugerencias;
	}

	/**
	 * Gets the id usuario.
	 *
	 * @return the id usuario
	 */
	public Long getIdUsuario() {
		return idUsuario;
	}

	/**
	 * Sets the id usuario.
	 *
	 * @param idUsuario the new id usuario
	 */
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * Gets the estado.
	 *
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Sets the estado.
	 *
	 * @param estado the new estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
