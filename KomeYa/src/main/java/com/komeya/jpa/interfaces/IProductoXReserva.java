package com.komeya.jpa.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.komeya.jpa.modelo.Producto;
import com.komeya.jpa.modelo.ProductoXReserva;

@Repository
public interface IProductoXReserva extends CrudRepository<ProductoXReserva, Long>{


	public List<ProductoXReserva> findByIdReserva(Long id);
	
	
}
