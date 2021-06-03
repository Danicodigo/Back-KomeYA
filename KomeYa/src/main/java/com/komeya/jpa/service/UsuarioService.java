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
import com.komeya.jpa.modelo.LoginForm;
import com.komeya.jpa.modelo.Producto;
import com.komeya.jpa.modelo.Reserva;
import com.komeya.jpa.modelo.Usuario;
import com.komeya.jpa.utils.BCrypt;
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
	  public ResponseEntity<Usuario> updateUsuario( Long id,  Usuario u) {
	    Optional<Usuario> tutorialData = usuario.findById(id);

	    if (tutorialData.isPresent()) {
	      Usuario _usuario = tutorialData.get();
	      _usuario.setNombre(u.getNombre());
	      _usuario.setApellidos(u.getApellidos());
	      _usuario.setCiudad(u.getCiudad());
	      _usuario.setContrasenia(BCrypt.hashpw(u.getContrasenia(), BCrypt.gensalt()));
	      _usuario.setEmail(u.getEmail());
	      _usuario.setNombreUsuario(u.getNombreUsuario());
	      _usuario.setRolUsuario(u.getRolUsuario());
	      _usuario.setDireccion(u.getDireccion());
	      return new ResponseEntity<>(usuario.save(_usuario), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	@Override
	public ResponseEntity<Usuario>createUsuario(Usuario r) {

		 try {
			 r.setContrasenia(BCrypt.hashpw(r.getContrasenia(), BCrypt.gensalt()));
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



	@Override
	public ResponseEntity<Usuario> login(LoginForm loginform) {

			
		 	Usuario data = usuario.findByEmail(loginform.getEmail());
		 	if(BCrypt.checkpw(loginform.getPass(), data.getContrasenia())) {
		      return new ResponseEntity<>(data, HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
	
	}

}
