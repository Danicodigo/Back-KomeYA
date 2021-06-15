package com.komeya.jpa.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.komeya.jpa.security.entity.Usuario;
import com.komeya.jpa.security.entity.UsuarioPrincipal;

/**
 * The Class UserDetailsServiceImpl. La clase que gestiona los servicios de los usuarios
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    /** The usuario service. */
    @Autowired
    UsuarioServiceJwt usuarioService;

    /**
     * Load user by username.
     *
     * @param nombreUsuario the nombre usuario
     * @return the user details
     * @throws UsernameNotFoundException the username not found exception
     */
    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        return UsuarioPrincipal.build(usuario);
    }
}