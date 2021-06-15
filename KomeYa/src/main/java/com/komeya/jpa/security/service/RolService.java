package com.komeya.jpa.security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.komeya.jpa.security.entity.Rol;
import com.komeya.jpa.security.enums.RolNombre;
import com.komeya.jpa.security.repository.RolRepository;

import java.util.Optional;

/**
 * The Class RolService. La clase que gestiona los servicios de los roles
 * 
 * @author Dani Kuradchyk
 */
@Service
@Transactional
public class RolService {

    /** The rol repository. */
    @Autowired
    RolRepository rolRepository;

    /**
     * Gets the by rol nombre.
     *
     * @param rolNombre the rol nombre
     * @return the by rol nombre
     */
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    /**
     * Save.
     *
     * @param rol the rol
     */
    public void save(Rol rol){
        rolRepository.save(rol);
    }
}