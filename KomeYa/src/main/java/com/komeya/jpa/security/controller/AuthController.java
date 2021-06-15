package com.komeya.jpa.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.komeya.jpa.interfaces.IUsuario;
import com.komeya.jpa.security.dto.JwtDto;
import com.komeya.jpa.security.dto.LoginUsuario;
import com.komeya.jpa.security.dto.NuevoUsuario;
import com.komeya.jpa.security.entity.Rol;
import com.komeya.jpa.security.entity.Usuario;
import com.komeya.jpa.security.enums.RolNombre;
import com.komeya.jpa.security.jwt.JwtProvider;
import com.komeya.jpa.security.service.RolService;

import com.komeya.jpa.security.service.UsuarioServiceJwt;
import com.komeya.jpa.security.util.Mensaje;

import java.util.HashSet;
import java.util.Set;

/**
 * The Class AuthController. Esta clase se encarga de controlar los usuarios de
 * la aplicacion.
 * 
 * @author Dani Kuradchyk
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

	/** The password encoder. */
	@Autowired
	PasswordEncoder passwordEncoder;

	/** The authentication manager. */
	@Autowired
	AuthenticationManager authenticationManager;

	/** The usuario rep. */
	@Autowired
	IUsuario usuarioRep;

	/** The usuario service. */
	@Autowired
	UsuarioServiceJwt usuarioService;

	/** The rol service. */
	@Autowired
	RolService rolService;

	/** The jwt provider. */
	@Autowired
	JwtProvider jwtProvider;

	/**
	 * Crea un nuevo usuario comprobando sus campos
	 *
	 * @param nuevoUsuario  the nuevo usuario
	 * @param bindingResult the binding result
	 * @return the response entity
	 */
	@PostMapping("/nuevo")
	public ResponseEntity<?> nuevo(@RequestBody NuevoUsuario nuevoUsuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return new ResponseEntity(new Mensaje("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
		if (usuarioService.existsByNombreUsuario(nuevoUsuario.getNombreUsuario()))
			return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
		if (usuarioService.existsByEmail(nuevoUsuario.getEmail()))
			return new ResponseEntity(new Mensaje("ese email ya existe"), HttpStatus.BAD_REQUEST);
		Usuario usuario = new Usuario(nuevoUsuario.getNombre(), nuevoUsuario.getApellidos(), nuevoUsuario.getEmail(),
				nuevoUsuario.getNombreUsuario(), passwordEncoder.encode(nuevoUsuario.getPassword()),
				nuevoUsuario.getRolUsuario(), nuevoUsuario.getCiudad(), nuevoUsuario.getDireccion());
		Set<Rol> roles = new HashSet<>();
		roles.add(rolService.getByRolNombre(RolNombre.ROLE_USER).get());
		if (nuevoUsuario.getRoles().contains("admin"))
			roles.add(rolService.getByRolNombre(RolNombre.ROLE_ADMIN).get());
		usuario.setRoles(roles);
		usuarioService.save(usuario);
		return new ResponseEntity(new Mensaje("usuario guardado"), HttpStatus.CREATED);
	}

	/**
	 * Comprueba las credenciales de un usuario para loguearse y devolver el token
	 *
	 * @param loginUsuario  the login usuario
	 * @param bindingResult the binding result
	 * @return the response entity
	 */
	@PostMapping("/login")
	public ResponseEntity<JwtDto> login(@RequestBody LoginUsuario loginUsuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return new ResponseEntity(new Mensaje("campos mal puestos"), HttpStatus.BAD_REQUEST);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUsuario.getNombreUsuario(), loginUsuario.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		return new ResponseEntity(jwtDto, HttpStatus.OK);
	}
}