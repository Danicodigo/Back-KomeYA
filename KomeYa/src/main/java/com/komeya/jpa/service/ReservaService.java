package com.komeya.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.komeya.jpa.interfaceService.IReservaService;
import com.komeya.jpa.interfaces.IProducto;
import com.komeya.jpa.interfaces.IReserva;
import com.komeya.jpa.modelo.Producto;
import com.komeya.jpa.modelo.Reserva;
import com.komeya.jpa.modelo.Usuario;
import com.komeya.jpa.utils.BCrypt;
@Service
public class ReservaService implements IReservaService{

	@Autowired
	private IReserva reserva;

	
	@Override
	public ResponseEntity<List<Reserva>> getReservas() {
		try {
		      List<Reserva> productoss = new ArrayList<Reserva>();

		     
		      reserva.findAll().forEach(productoss::add);
		   

		      if (productoss.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(productoss, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}



	@Override
	public ResponseEntity<Reserva>createReserva(Reserva r) {
		// TODO Auto-generated method stub
		 try {
			 Reserva _producto = reserva.save(r);
		      return new ResponseEntity<>(_producto, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}

	@Override
	public ResponseEntity<Reserva> getReserva(Long id) {
		 Optional<Reserva> data = reserva.findById(id);

		    if (data.isPresent()) {
		      return new ResponseEntity<>(data.get(), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
	}
	@Override
	public ResponseEntity<Reserva> deleteReserva(Long id) {
		  try {
			  reserva.deleteById(id);
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }	
	}

	@Override
	public ResponseEntity<List<Reserva>> getReservasByUsuario(Long id) {
		try {
		      List<Reserva> productoss = new ArrayList<Reserva>();

		     
		      reserva.findReservasByUser(id).forEach(productoss::add);
		   
		      System.out.println(productoss.get(0).getIdUsuario());
		      if (productoss.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(productoss, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}



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
