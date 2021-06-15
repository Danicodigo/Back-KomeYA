package com.komeya.jpa.security.entity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


/**
 * CLase de usuario principal que sirve para almacenar los datos de user details 
 * 
 * @author Dani Kuradchyk
 */
public class UsuarioPrincipal implements UserDetails {
    
    /** The nombre. */
    private String nombre;
    
    /** The apellidos. */
    private String apellidos;
    
    /** The nombre usuario. */
    private String nombreUsuario;
    
    /** The email. */
    private String email;
    
    /** The password. */
    private String password;
	
	/** The rol usuario. */
	private String rolUsuario ;
	
	/** The ciudad. */
	private String ciudad ;
	
	/** The direccion. */
	private String direccion ;
    
    /** The authorities. */
    private Collection<? extends GrantedAuthority> authorities;



    /**
     * Instantiates a new usuario principal.
     *
     * @param nombre the nombre
     * @param apellidos the apellidos
     * @param nombreUsuario the nombre usuario
     * @param email the email
     * @param password the password
     * @param rolUsuario the rol usuario
     * @param ciudad the ciudad
     * @param direccion the direccion
     * @param authorities the authorities
     */
    public UsuarioPrincipal(String nombre, String apellidos, String nombreUsuario, String email, String password,
			String rolUsuario, String ciudad, String direccion, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.password = password;
		this.rolUsuario = rolUsuario;
		this.ciudad = ciudad;
		this.direccion = direccion;
		this.authorities = authorities;
	}

	/**
	 * Builds the.
	 *
	 * @param usuario the usuario
	 * @return the usuario principal
	 */
	public static UsuarioPrincipal build(Usuario usuario){
    	List<GrantedAuthority> authorities =
                usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol
                .getRolNombre().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getNombre(),usuario.getApellidos(), usuario.getNombreUsuario(),
        usuario.getEmail(), usuario.getContrasenia(),usuario.getRolUsuario(),usuario.getCiudad(),usuario.getDireccion(), authorities);
    }

    /**
     * Gets the authorities.
     *
     * @return the authorities
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    /**
     * Checks if is account non expired.
     *
     * @return true, if is account non expired
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Checks if is account non locked.
     *
     * @return true, if is account non locked
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Checks if is credentials non expired.
     *
     * @return true, if is credentials non expired
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Checks if is enabled.
     *
     * @return true, if is enabled
     */
    @Override
    public boolean isEnabled() {
        return true;
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
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
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
	 * Gets the rol usuario.
	 *
	 * @return the rol usuario
	 */
	public String getRolUsuario() {
		return rolUsuario;
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
	 * Gets the direccion.
	 *
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
    
    
}