package com.komeya.jpa.security.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

/**
 * La clase que servira como entidad para almacenar la tabla de usuario en la
 * base de datoas.
 * 
 * @author Dani Kuradchyk
 */
@Entity
@Table(name = "usuario")
public class Usuario {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** The nombre. */
	@Pattern(regexp = "^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.\\'-]+$", 
			message = "El nombre es incorrecto.")
	private String nombre;

	/** The apellidos. */
	@Pattern(regexp = "^[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.\\'-]+$", 
			message = "El apellido es incorrecto.")
	private String apellidos;

	/** The email. */
	private String email;

	/** The nombre usuario. */
	@Column(unique = true)
	@Pattern(regexp = "^[a-zA-Z0-9._-]{4,20}$", message = "El nombre de usuario es incorrecto.")
	private String nombreUsuario;

	/** The contrasenia. */
	private String contrasenia;

	/** The rol usuario. */
	private String rolUsuario;

	/** The ciudad. */
	private String ciudad;

	/** The direccion. */
	@Pattern(regexp = "^[a-zA-Z0-9._ /,-]{10,100}$", message = "La direccion es incorrecta")
	private String direccion;

	/** The roles. */
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private Set<Rol> roles = new HashSet<>();

	/**
	 * Instantiates a new usuario.
	 *
	 * @param nombre        the nombre
	 * @param apellidos     the apellidos
	 * @param email         the email
	 * @param nombreUsuario the nombre usuario
	 * @param contrasenia   the contrasenia
	 * @param rolUsuario    the rol usuario
	 * @param ciudad        the ciudad
	 * @param direccion     the direccion
	 */
	public Usuario(String nombre, String apellidos, String email, String nombreUsuario, String contrasenia,
			String rolUsuario, String ciudad, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
		this.rolUsuario = rolUsuario;
		this.ciudad = ciudad;
		this.direccion = direccion;
	}

	/**
	 * Instantiates a new usuario.
	 */
	public Usuario() {
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
	 * Gets the apellidos.
	 *
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Sets the apellidos.
	 *
	 * @param apellidos the new apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the nombre usuario.
	 *
	 * @return the nombre usuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * Sets the nombre usuario.
	 *
	 * @param nombreUsuario the new nombre usuario
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * Gets the contrasenia.
	 *
	 * @return the contrasenia
	 */
	public String getContrasenia() {
		return contrasenia;
	}

	/**
	 * Sets the contrasenia.
	 *
	 * @param contrasenia the new contrasenia
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	/**
	 * Gets the rol usuario.
	 *
	 * @return the rol usuario
	 */
	public String getRolUsuario() {
		return rolUsuario;
	}

	/**
	 * Sets the rol usuario.
	 *
	 * @param rolUsuario the new rol usuario
	 */
	public void setRolUsuario(String rolUsuario) {
		this.rolUsuario = rolUsuario;
	}

	/**
	 * Gets the ciudad.
	 *
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * Sets the ciudad.
	 *
	 * @param ciudad the new ciudad
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * Gets the direccion.
	 *
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Sets the direccion.
	 *
	 * @param direccion the new direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Gets the roles.
	 *
	 * @return the roles
	 */
	public Set<Rol> getRoles() {
		return roles;
	}

	/**
	 * Sets the roles.
	 *
	 * @param roles the new roles
	 */
	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

}
