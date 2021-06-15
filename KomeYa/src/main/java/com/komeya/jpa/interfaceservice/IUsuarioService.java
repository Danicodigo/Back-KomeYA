package com.komeya.jpa.interfaceservice;
import java.util.List;
import org.springframework.http.ResponseEntity;
import com.komeya.jpa.security.entity.Usuario;

/**
 * The Interface IUsuarioService.
 */
public interface IUsuarioService {
	
	/**
	 * Gets the usuarios.
	 *
	 * @return the usuarios
	 */
	public ResponseEntity<List<Usuario>> getUsuarios();
	
	/**
	 * Gets the usuario.
	 *
	 * @param id the id
	 * @return the usuario
	 */
	public ResponseEntity<Usuario>getUsuario(Long id);
	
	/**
	 * Delete usuario.
	 *
	 * @param id the id
	 * @return the response entity
	 */
	public ResponseEntity<Usuario>  deleteUsuario(Long id);
	
	/**
	 * Update usuario.
	 *
	 * @param id the id
	 * @param producto the producto
	 * @return the response entity
	 */
	ResponseEntity<Usuario> updateUsuario(Long id, Usuario producto);
	
	/**
	 * Gets the id usuario by nombre usuario.
	 *
	 * @param username the username
	 * @return the id usuario by nombre usuario
	 */
	ResponseEntity<Usuario> getIdUsuarioByNombreUsuario(String username);
	
}
