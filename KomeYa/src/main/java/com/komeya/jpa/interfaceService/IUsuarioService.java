package com.komeya.jpa.interfaceService;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.komeya.jpa.modelo.Usuario;

public interface IUsuarioService {
	
	public ResponseEntity<List<Usuario>> getUsuarios();
	public ResponseEntity<Usuario>getUsuario(Long id);
	public ResponseEntity<Usuario> createUsuario(Usuario u);
	public ResponseEntity<Usuario>  deleteUsuario(Long id);
	
}
