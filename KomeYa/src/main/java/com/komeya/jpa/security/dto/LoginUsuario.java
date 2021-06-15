package com.komeya.jpa.security.dto;

/**
 * Esta clase sirve para tener un objeto de logueo con solo el nombre de usuario y la contraseña 
 * 
 * @author Dani Kuradchyk
 */
public class LoginUsuario {
    
    /** The nombre usuario. */
    private String nombreUsuario;
    
    /** The password. */
    private String password;

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
}