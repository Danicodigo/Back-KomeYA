package com.komeya.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.komeya.jpa.interfaces.IUsuario;
import com.komeya.jpa.interfaceservice.IUsuarioService;
import com.komeya.jpa.security.entity.Usuario;

/**
 * The Class UsuarioService.
 */
@Service
public class UsuarioService implements IUsuarioService {

	/** The usuario. */
	@Autowired
	private IUsuario usuario;

	/** The password encoder. */
	@Autowired
	PasswordEncoder passwordEncoder;

	/**
	 * Devuelve una lista de usuarios
	 *
	 * @return the usuarios
	 */
	@Override
	public ResponseEntity<List<Usuario>> getUsuarios() {
		try {
			List<Usuario> usuarioss = new ArrayList<>();

			usuario.findAll().forEach(usuarioss::add);

			if (usuarioss.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(usuarioss, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 *Actualiza un usuario
	 *
	 * @param id del usuario
	 * @param u 
	 * @return usuario actualizado
	 */
	@Override
	public ResponseEntity<Usuario> updateUsuario(Long id, Usuario u) {
		Optional<Usuario> tutorialData = usuario.findById(id);

		if (tutorialData.isPresent()) {
			Usuario usr = tutorialData.get();
			usr.setNombre(u.getNombre());
			usr.setApellidos(u.getApellidos());
			usr.setCiudad(u.getCiudad());
			usr.setContrasenia(passwordEncoder.encode(u.getContrasenia()));
			usr.setEmail(u.getEmail());
			usr.setNombreUsuario(u.getNombreUsuario());
			usr.setRolUsuario(u.getRolUsuario());
			usr.setDireccion(u.getDireccion());
			usuario.save(usr);
			return new ResponseEntity<>(usr, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Devuelve un usuario a partir de su id
	 *
	 * @param id del usuario
	 * @return the usuario
	 */
	@Override
	public ResponseEntity<Usuario> getUsuario(Long id) {
		Optional<Usuario> data = usuario.findById(id);

		if (data.isPresent()) {
			return new ResponseEntity<>(data.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Borra un usuario a partir de su id
	 *
	 * @param id del usuario
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<Usuario> deleteUsuario(Long id) {
		try {
			usuario.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Devuelve un usuario a partir del nombre de usuario
	 *
	 * @param username
	 * @return usuario solicitado
	 */
	@Override
	public ResponseEntity<Usuario> getIdUsuarioByNombreUsuario(String username) {
		try {
			Usuario data = usuario.findByNombreUsuario(username);
			return new ResponseEntity<>(data, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
