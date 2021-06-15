package com.komeya.jpa.security.entity;



import javax.persistence.*;

import com.komeya.jpa.security.enums.RolNombre;

/**
 * La clase que guardara el rol en la base de datos.
 * 
 * @author Dani Kuradchyk
 */
@Entity
public class Rol {
    
    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    /** The rol nombre. */
    @Enumerated(EnumType.STRING)
    private RolNombre rolNombre;

    /**
     * Instantiates a new rol.
     */
    public Rol() {
    }

    /**
     * Instantiates a new rol.
     *
     * @param rolNombre the rol nombre
     */
    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the rol nombre.
     *
     * @return the rol nombre
     */
    public RolNombre getRolNombre() {
        return rolNombre;
    }

    /**
     * Sets the rol nombre.
     *
     * @param rolNombre the new rol nombre
     */
    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}