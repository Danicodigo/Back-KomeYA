package com.komeya.jpa.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.komeya.jpa.modelo.ProductoXReserva;
import com.komeya.jpa.modelo.Usuario;
@Repository
public interface IUsuario extends CrudRepository<Usuario, Long> {
	@Query(value = "SELECT * FROM komeya.`usuario` where email like :email and contrasenia like :pass", nativeQuery = true)
	public Optional<Usuario> findByEmailAndContrasenia(String email, String pass);
	

	Usuario findByEmail(String email);
}
