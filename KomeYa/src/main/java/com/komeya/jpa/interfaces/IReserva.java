package com.komeya.jpa.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.komeya.jpa.modelo.Reserva;

/**
 * Esta clase sirve de repositorio de las relaciones de los productos con reserva
 * 
 * @author Dani Kuradchyk
 */
@Repository
public interface IReserva extends CrudRepository<Reserva, Long> {

	/**
	 * Devuelve una reserva a partir del id de usuario
	 *
	 * @param id delusuario de la reserva
	 * @return la reserva solicitada
	 */
	public List<Reserva> findByIdUsuario(Long id);
}
