package com.komeya.jpa.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.komeya.jpa.interfaceService.IReservaService;
import com.komeya.jpa.interfaceService.IUsuarioService;
import com.komeya.jpa.modelo.Reserva;
import com.komeya.jpa.modelo.Usuario;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping()
public class UsuarioController {
	@Autowired
	private IUsuarioService usuarioService;
	
	
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> getUsuarios(){
		ResponseEntity<List<Usuario>> reservas=usuarioService.getUsuarios();
		return reservas;
		
	}
	@GetMapping("/usuario/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable("id") Long id){
		ResponseEntity<Usuario> reserva=usuarioService.getUsuario(id);
		return reserva;
		
	}
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<Usuario> deletesuario(@PathVariable("id") Long id){
		return usuarioService.deleteUsuario(id);
	}
	
	@PostMapping("/crearUsuario")
	public ResponseEntity<Usuario> crearsuario(@RequestBody Usuario p) {
		return usuarioService.createUsuario(p);
	}
}
