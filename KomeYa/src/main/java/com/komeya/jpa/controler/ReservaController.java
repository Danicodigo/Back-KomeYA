package com.komeya.jpa.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.komeya.jpa.interfaceservice.IReservaService;
import com.komeya.jpa.modelo.Reserva;

/**
 * Clase del controlador de Productos, se encarga de establecer las rutas de los servicios de los productos.
 * 
 * @author Dani Kuradchyk
 * @version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping()
public class ReservaController {

	/** Reserva service. se encarga de proveer los servicios al controlador*/
	@Autowired
	private IReservaService reservaService;
	
	
	/**
	 * Este metodo se encarga asignar una ruta al metodo, 
	 * este metodo devolvera una lista de todas las reservas
	 *
	 * @return the reservas
	 */
	@GetMapping("/reservas")
	public ResponseEntity<List<Reserva>> getReservas(){
	
		return reservaService.getReservas();
		
	}
	
	/**
	 * Este metodo se encarga asignar una ruta al metodo, 
	 * este metodo devolvera una reserva dependiendo del id que se le pase.
	 *
	 * @param id de la reserva
	 * @return reserva solicitada
	 */
	@GetMapping("/reserva/{id}")
	public ResponseEntity<Reserva> getReserva(@PathVariable("id") Long id){

		return reservaService.getReserva(id);
		
	}
	
	/**
	 * Este metodo se encarga asignar una ruta al metodo, 
	 * este metodo borra una reserva
	 * 
	 * @param id de la reseva a borrar
	 * @return the response entity
	 */
	@DeleteMapping("/reserva/{id}")
	public ResponseEntity<Reserva> deleteReserva(@PathVariable("id") Long id){
		return reservaService.deleteReserva(id);
	}
	
	/**
	 * Este metodo se encarga asignar una ruta al metodo, 
	 * este metodo crea una reserva
	 *
	 * @param reserva la reserva a crear
	 * @return the response entity
	 */
	@PostMapping("/crearReserva")
	public ResponseEntity<Reserva> crearReserva(@RequestBody Reserva reserva) {
		
		return reservaService.createReserva(reserva);
	}

	/**
	 * Este metodo se encarga asignar una ruta al metodo, 
	 * este metodo devuelve una lisra de reservas de un usuario
	 *
	 * @param id del usuario
	 * @return listado de las reservas del usuario
	 */
	@GetMapping("/reservasDeUsuario/{id}")
	public ResponseEntity<List<Reserva>> getProductosXReserva( @PathVariable("id") Long id){
		
		return reservaService.getReservasByUsuario(id);
		
	}
	
	/**
	 * Este metodo se encarga asignar una ruta al metodo, 
	 * este metodo actualiza una  reservas
	 *
	 * @param id de la reserva
	 * @param reserva the reserva
	 * @return reserva actualizada
	 */
	@PatchMapping("/reserva/{id}")
	  public ResponseEntity<Reserva> updateUsuario(@PathVariable("id") Long id, @RequestBody Reserva reserva) {
	   return reservaService.updateReserva(id, reserva);
	  }
}
