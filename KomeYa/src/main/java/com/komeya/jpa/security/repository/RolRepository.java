package com.komeya.jpa.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.komeya.jpa.security.entity.Rol;
import com.komeya.jpa.security.enums.RolNombre;

import java.util.Optional;


/**
 * The Interface RolRepository. el repositorio del rol
 * 
 * @author Dani Kuradchyk
 */
@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    
    /**
     * Find by rol nombre.
     *
     * @param rolNombre the rol nombre
     * @return the optional
     */
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}