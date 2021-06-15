package com.komeya.jpa.security.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * La clase del objeto de usuario
 * 
 * 
 * @author Dani Kuradchyk
 */
public class NuevoUsuario {

    /** The nombre. */
    private String nombre;
	
	/** The apellidos. */
	private String apellidos;
    
    /** The email. */
    private String email;
    
    /** The nombre usuario. */
    private String nombreUsuario;
    
    /** The password. */
    private String password;
	
	/** The rol usuario. */
	private String rolUsuario ;
	
	/** The ciudad. */
	private String ciudad ;
	
	/** The direccion. */
	private String direccion ;
    
    /** The roles. */
    private Set<String> roles = new HashSet<>();

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
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the roles.
     *
     * @return the roles
     */
    public Set<String> getRoles() {
        return roles;
    }

    /**
     * Sets the roles.
     *
     * @param roles the new roles
     */
    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}