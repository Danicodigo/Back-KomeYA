package com.komeya.jpa.interfaces;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.komeya.jpa.modelo.ProductoXReserva;

/**
 * Esta clase sirve de repositorio de las relaciones de los productos con reserva
 * 
 * @author Dani Kuradchyk
 */
@Repository
public interface IProductoXReserva extends CrudRepository<ProductoXReserva, Long>{

	/**
	 * Devuelve un listado de relaciones por el id de la reserva
	 *
	 * @param id de la reserva
	 * @return el listado
	 */
	public List<ProductoXReserva> findByIdReserva(Long id);
	
	
}
