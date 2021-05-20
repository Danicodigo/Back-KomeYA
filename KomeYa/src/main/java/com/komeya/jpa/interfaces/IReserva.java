package com.komeya.jpa.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.komeya.jpa.modelo.Reserva;
import com.komeya.jpa.modelo.Usuario;

@Repository
public interface IReserva extends CrudRepository<Reserva, Long> {

}
