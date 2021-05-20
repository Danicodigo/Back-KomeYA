package com.komeya.jpa.modelo;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PK_Id", unique = true, nullable = false)
	private Long id;
	private Date fecha;
	private Time hora;
	private String tipoReserva;
	private Integer numPersonas;
	private String sugerencias;
	
	private Long idUsuario;

	public Reserva(Long id, Date fecha, Time hora, String tipoReserva, Integer numPersonas, String sugerencias,
			Long idUsuario) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.tipoReserva = tipoReserva;
		this.numPersonas = numPersonas;
		this.sugerencias = sugerencias;
		this.idUsuario = idUsuario;
	}

	public Reserva() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getTipoReserva() {
		return tipoReserva;
	}

	public void setTipoReserva(String tipoReserva) {
		this.tipoReserva = tipoReserva;
	}

	public Integer getNumPersonas() {
		return numPersonas;
	}

	public void setNumPersonas(Integer numPersonas) {
		this.numPersonas = numPersonas;
	}

	public String getSugerencias() {
		return sugerencias;
	}

	public void setSugerencias(String sugerencias) {
		this.sugerencias = sugerencias;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
	}
