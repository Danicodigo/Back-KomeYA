package com.komeya.jpa.interfaces;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.komeya.jpa.security.entity.Usuario;


/**
 * Esta clase sirve de repositorio de las relaciones de los usuarios
 * 
 * @author Dani Kuradchyk
 */
@Repository
public interface IUsuario extends CrudRepository<Usuario, Long> {
	

	/**
	 * Devuelve un usuario por su email
	 *
	 * @param email del usuario
	 * @return el usuario solicitado
	 */
	Usuario findByEmail(String email);

	
	/**
	 * Devuelve un usuario por su email
	 *
	 * @param username del usuario
	 * @return el usuario solicitado
	 */
	Usuario findByNombreUsuario(String username);
}
