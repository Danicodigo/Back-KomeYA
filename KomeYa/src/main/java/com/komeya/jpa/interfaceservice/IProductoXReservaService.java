package com.komeya.jpa.interfaceservice;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.komeya.jpa.modelo.Producto;
import com.komeya.jpa.modelo.ProductoXReserva;
import com.komeya.jpa.modelo.Reserva;

/**
 * The Interface IProductoXReservaService.
 */
public interface IProductoXReservaService {
	
	/**
	 * Metodo abstracto que añade un producto a un reserva
	 *
	 * @param productXReserva the product X reserva
	 * @return the response entity
	 */
	public ResponseEntity<ProductoXReserva> addProductToReserva(ProductoXReserva productXReserva);
	
	/**
	 *Metodo abstracto que borra un producto de un reserva
	 *
	 * @param id de la relacion
	 * @return the response entity
	 */
	ResponseEntity<ProductoXReserva> deleteProductoFromReserva(Long id);
	
	/**
	 * Metodo abstracto que devuelce un listado de productos
	 *
	 * @param id de  reserva
	 * @return  productos de reserva
	 */
	ResponseEntity<List<Producto>> getProductosDeReserva(Long id);
	
	/**
	 * Metodo abstracto que devuelve una lista de la reslaciones a partir del id de una reserva.
	 *
	 * @param id de reserva
	 * @return the productos X reserva
	 */
	ResponseEntity<List<ProductoXReserva>> getProductosXReserva(Long id);
}
