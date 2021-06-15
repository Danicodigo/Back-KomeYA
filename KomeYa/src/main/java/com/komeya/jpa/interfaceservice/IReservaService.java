package com.komeya.jpa.interfaceservice;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.komeya.jpa.modelo.Reserva;

/**
 * The Interface IReservaService.
 */
public interface IReservaService {

	/**
	 * Metodo abstracto que devuelve un listado de reservas
	 *
	 * @return the reservas
	 */
	public ResponseEntity<List<Reserva>>getReservas();
	
	/**
	 *Metodo abstracto que devuelve un reserva
	 *
	 * @param id de la reserva
	 * @return the reserva
	 */
	public ResponseEntity<Reserva>getReserva(Long id);
	
	/**
	 * Metodo abstracto que crea una reserva
	 *
	 * @param r la reserva
	 * @return the response entity
	 */
	public ResponseEntity<Reserva> createReserva(Reserva r);
	
	/**
	 *  Metodo abstracto que borra una reserva
	 *
	 * @param id del la reserva
	 * @return the response entity
	 */
	ResponseEntity<Reserva> deleteReserva(Long id);
	
	/**
	 * Metodo abstracto que devuelve una lista de reservas a partir de un usuario
	 *
	 * @param id del usuario
	 * @return lista de reservas
	 */
	ResponseEntity<List<Reserva>> getReservasByUsuario(Long id);
	
	/**
	 *  Metodo abstracto que actualiza una reserva
	 *
	 * @param id de la reserva
	 * @param res reserva
	 * @return reserva actualizada
	 */
	ResponseEntity<Reserva> updateReserva(Long id, Reserva res);
}
