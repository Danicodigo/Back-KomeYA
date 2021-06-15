package com.komeya.jpa.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.komeya.jpa.interfaceservice.IUsuarioService;
import com.komeya.jpa.security.entity.Usuario;

/**
 * Clase del controlador de Productos, se encarga de establecer las rutas de los servicios de los productos.
 * 
 * @author Dani Kuradchyk
 * @version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping()
public class UsuarioController {

	/** usuario service. se encarga de proveer los servicios al controlador*/
	@Autowired
	private IUsuarioService usuarioService;
	
	
	/**
	 * Este metodo se encarga asignar una ruta al metodo, 
	 * este metodo devuelve una lista de usuarios
	 *
	 * @return una lista usuarios
	 */
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> getUsuarios(){
	
		return usuarioService.getUsuarios();
		
	}
	
	/**
	* Este metodo se encarga asignar una ruta al metodo, 
	 * este metodo actualiza un usuario.
	 *
	 * @param id del usuario a cambiar
	 * @param usuario nuevo
	 * @return usuario actualizado
	 */
	@PatchMapping("/usuario/{id}")
	  public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
	   return  usuarioService.updateUsuario(id, usuario);
	  }
	
	/**
	 * Este metodo se encarga asignar una ruta al metodo, 
	 * este metodo devuelve un usario por el id
	 * 
	 * @param id del usuario
	 * @return el usuario solicitado
	 */
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable("id") Long id){
		
		return usuarioService.getUsuario(id);
		
	}
	
	/**
	 * Este metodo se encarga asignar una ruta al metodo, 
	 * este metodo borra un usuario
	 *
	 * @param id del usuario
	 * @return response entity
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<Usuario> deletesuario(@PathVariable("id") Long id){
		return usuarioService.deleteUsuario(id);
	}
	
	/**
	 * Este metodo se encarga asignar una ruta al metodo, 
	 * este metodo devuelve un usuario a partir de un nombre de usuario
	 *
	 * @param username nombre de usuario
	 * @return el usuario
	 */
	@GetMapping("/usuario/getIdusuario/{username}")
	public ResponseEntity<Usuario> getIdUsuarioByNombreUsuario(@PathVariable String username){
		return usuarioService.getIdUsuarioByNombreUsuario(username);
	}
	
}
