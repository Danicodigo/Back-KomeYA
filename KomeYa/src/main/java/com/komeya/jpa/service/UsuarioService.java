package com.komeya.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.komeya.jpa.interfaceService.IUsuarioService;
import com.komeya.jpa.interfaces.IReserva;
import com.komeya.jpa.interfaces.IUsuario;
import com.komeya.jpa.modelo.Reserva;
import com.komeya.jpa.modelo.Usuario;
@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	private IUsuario usuario;
	
	
	@Override
	public ResponseEntity<List<Usuario>> getUsuarios() {
		try {
		      List<Usuario> usuarioss = new ArrayList<Usuario>();

		     
		      usuario.findAll().forEach(usuarioss::add);
		   

		      if (usuarioss.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(usuarioss, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}



	@Override
	public ResponseEntity<Usuario>createUsuario(Usuario r) {

		 try {
			 Usuario _usuario = usuario.save(r);
		      return new ResponseEntity<>(_usuario, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}

	@Override
	public ResponseEntity<Usuario> getUsuario(Long id) {
		 Optional<Usuario> data = usuario.findById(id);

		    if (data.isPresent()) {
		      return new ResponseEntity<>(data.get(), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
	}
	@Override
	public ResponseEntity<Usuario> deleteUsuario(Long id) {
		  try {
			  usuario.deleteById(id);
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }	
	}

}
