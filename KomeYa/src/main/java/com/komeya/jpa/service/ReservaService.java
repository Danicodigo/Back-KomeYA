package com.komeya.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.komeya.jpa.interfaces.IReserva;
import com.komeya.jpa.interfaceservice.IReservaService;
import com.komeya.jpa.modelo.Reserva;

/**
 * The Class ReservaService. Clase que gestiona los servicios de las reservas.
 * 
 * @author Dani Kuradchyk
 */
@Service
public class ReservaService implements IReservaService {

	/** The reserva. */
	@Autowired
	private IReserva reserva;

	/**
	 * Devuelve un listado de reservas
	 *
	 * @return the reservas
	 */
	@Override
	public ResponseEntity<List<Reserva>> getReservas() {
		try {
			List<Reserva> productoss = new ArrayList<>();

			reserva.findAll().forEach(productoss::add);

			if (productoss.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(productoss, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Crea una reserva
	 *
	 * @param r reserva
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<Reserva> createReserva(Reserva r) {
		try {
			Reserva producto = reserva.save(r);
			return new ResponseEntity<>(producto, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Devuelve una reserva a partir de una id
	 *
	 * @param id de la reserva
	 * @return the reserva
	 */
	@Override
	public ResponseEntity<Reserva> getReserva(Long id) {
		Optional<Reserva> data = reserva.findById(id);

		if (data.isPresent()) {
			return new ResponseEntity<>(data.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Borra una reserva a partir de una id
	 *
	 * @param id de la reserva
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<Reserva> deleteReserva(Long id) {
		try {
			reserva.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Devuelve las reservas de un usuario
	 *
	 * @param id del usuario
	 * @return the reservas by usuario
	 */
	@Override
	public ResponseEntity<List<Reserva>> getReservasByUsuario(Long id) {
		try {
			List<Reserva> productoss = new ArrayList<>();
			reserva.findByIdUsuario(id).forEach(productoss::add);
			if (productoss.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(productoss, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Actualiza una reserva
	 *
	 * @param id de la reserva
	 * @param reserva
	 * @return reserva actualizada
	 */
	@Override
	public ResponseEntity<Reserva> updateReserva(Long id, Reserva res) {
		Optional<Reserva> tutorialData = reserva.findById(id);

		if (tutorialData.isPresent()) {
			Reserva r = tutorialData.get();
			r.setEstado(res.getEstado());
			return new ResponseEntity<>(reserva.save(r), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
