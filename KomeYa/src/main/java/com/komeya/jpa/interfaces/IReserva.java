package com.komeya.jpa.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.komeya.jpa.modelo.ProductoXReserva;
import com.komeya.jpa.modelo.Reserva;
import com.komeya.jpa.modelo.Usuario;

@Repository
public interface IReserva extends CrudRepository<Reserva, Long> {
	@Query(value = "SELECT * FROM komeya.`reserva` where id_usuario like :id", nativeQuery = true)
	public List<Reserva> findReservasByUser(Long id);
}
