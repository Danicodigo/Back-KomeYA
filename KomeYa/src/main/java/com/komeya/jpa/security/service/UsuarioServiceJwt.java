package com.komeya.jpa.security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.komeya.jpa.security.entity.Usuario;
import com.komeya.jpa.security.repository.UsuarioRepository;

import java.util.Optional;

/**
 * The Class UsuarioServiceJwt. La clase que gestiona los servicios de los usuarios
 */
@Service
@Transactional
public class UsuarioServiceJwt {

    /** The usuario repository. */
    @Autowired
    UsuarioRepository usuarioRepository;

    /**
     * Gets the by nombre usuario.
     *
     * @param nombreUsuario the nombre usuario
     * @return the by nombre usuario
     */
    public Optional<Usuario> getByNombreUsuario(String nombreUsuario){
        return usuarioRepository.findByNombreUsuario(nombreUsuario);
    }

    /**
     * Exists by nombre usuario.
     *
     * @param nombreUsuario the nombre usuario
     * @return true, if successful
     */
    public boolean existsByNombreUsuario(String nombreUsuario){
        return usuarioRepository.existsByNombreUsuario(nombreUsuario);
    }

    /**
     * Exists by email.
     *
     * @param email the email
     * @return true, if successful
     */
    public boolean existsByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }

    /**
     * Save.
     *
     * @param usuario the usuario
     */
    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }
}