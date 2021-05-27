package com.komeya.jpa.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.komeya.jpa.interfaceService.IReservaService;
import com.komeya.jpa.modelo.Producto;
import com.komeya.jpa.modelo.Reserva;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping()
public class ReservaController {
	@Autowired
	private IReservaService reservaService;
	
	
	@GetMapping("/reservas")
	public ResponseEntity<List<Reserva>> getReservas(){
		ResponseEntity<List<Reserva>> reservas=reservaService.getReservas();
		return reservas;
		
	}
	@GetMapping("/reserva/{id}")
	public ResponseEntity<Reserva> getReserva(@PathVariable("id") Long id){
		ResponseEntity<Reserva> reserva=reservaService.getReserva(id);
		return reserva;
		
	}
	@DeleteMapping("/reserva/{id}")
	public ResponseEntity<Reserva> deleteReserva(@PathVariable("id") Long id){
		return reservaService.deleteReserva(id);
	}
	
	@PostMapping("/crearReserva")
	public ResponseEntity<Reserva> crearReserva(@RequestBody Reserva p) {
		
		return reservaService.createReserva(p);
	}

	@GetMapping("/reservasDeUsuario/{id}")
	public ResponseEntity<List<Reserva>> getProductosXReserva( @PathVariable("id") Long id){
		
		ResponseEntity<List<Reserva>> productos=reservaService.getReservasByUsuario(id);
		return productos;
		
	}
}
