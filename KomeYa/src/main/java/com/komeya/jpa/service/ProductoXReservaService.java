package com.komeya.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.komeya.jpa.interfaces.IProductoXReserva;
import com.komeya.jpa.interfaceservice.IProductoService;
import com.komeya.jpa.interfaceservice.IProductoXReservaService;
import com.komeya.jpa.modelo.Producto;
import com.komeya.jpa.modelo.ProductoXReserva;

/**
 * The Class ProductoXReservaService. se encarga de gestionar los sservicos de
 * las relaciones entre los productos y las reservas
 * 
 * @author Dani Kuradchyk
 */
@Service
public class ProductoXReservaService implements IProductoXReservaService {

	/** The productoxreserva. */
	@Autowired
	IProductoXReserva productoxreserva;

	/** The productos. */
	@Autowired
	IProductoService productos;

	/**
	 * Añade the product to reserva.
	 *
	 * @param r ProductoXReserva
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<ProductoXReserva> addProductToReserva(ProductoXReserva r) {

		try {
			ProductoXReserva productoxreservaa = productoxreserva.save(r);
			return new ResponseEntity<>(productoxreservaa, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Borra producto from reserva.
	 *
	 * @param id de la relacion
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<ProductoXReserva> deleteProductoFromReserva(Long id) {
		try {
			productoxreserva.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Devuelve todas las relaciones a partid del id de reserva
	 *
	 * @param id de la reserva
	 * @return the productos X reserva
	 */
	@Override
	public ResponseEntity<List<ProductoXReserva>> getProductosXReserva(Long id) {
		try {
			List<ProductoXReserva> productoxreservaa = new ArrayList<>();

			productoxreserva.findByIdReserva(id).forEach(productoxreservaa::add);

			if (productoxreservaa.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(productoxreservaa, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Devuelve una lista de productos a partir de una reserva
	 *
	 * @param id de la reserva
	 * @return the productos de reserva
	 */
	@Override
	public ResponseEntity<List<Producto>> getProductosDeReserva(Long id) {
		try {
			List<ProductoXReserva> productoxreservaa = new ArrayList<>();
			List<Producto> products = new ArrayList<>();

			productoxreserva.findByIdReserva(id).forEach(productoxreservaa::add);

			for (ProductoXReserva oxp : productoxreservaa) {
				this.productos.getProducto(oxp.getIdProducto());

			}
			if (productoxreservaa.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
