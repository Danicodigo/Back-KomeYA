package com.komeya.jpa.interfaceService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.komeya.jpa.modelo.Reserva;
import com.komeya.jpa.modelo.Usuario;

public interface IReservaService {

	public ResponseEntity<List<Reserva>>getReservas();
	public ResponseEntity<Reserva>getReserva(Long id);
	public ResponseEntity<Reserva> createReserva(Reserva r);
	ResponseEntity<Reserva> deleteReserva(Long id);
}
