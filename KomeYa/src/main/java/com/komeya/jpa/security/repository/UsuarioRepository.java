package com.komeya.jpa.security.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.komeya.jpa.security.entity.Usuario;

import java.util.Optional;


/**
 * The Interface UsuarioRepository. repositorio de los usuarios
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    /**
     * Find by nombre usuario.
     *
     * @param nombreUsuario the nombre usuario
     * @return the optional
     */
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
    /**
     * Exists by nombre usuario.
     *
     * @param nombreUsuario the nombre usuario
     * @return true, if successful
     */
    boolean existsByNombreUsuario(String nombreUsuario);
    
    /**
     * Exists by email.
     *
     * @param email the email
     * @return true, if successful
     */
    boolean existsByEmail(String email);

}
