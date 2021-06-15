
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

import com.komeya.jpa.interfaceservice.IProductoXReservaService;
import com.komeya.jpa.modelo.Producto;
import com.komeya.jpa.modelo.ProductoXReserva;

/**
 * Clase del controlador de Productos, se encarga de establecer las rutas de los
 * servicios de los productos.
 * 
 * @author Dani Kuradchyk
 * @version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping()
public class ProductoXReservaController {

	/**
	 * ProductoXReserva service. se encarga de proveer los servicios al controlador
	 */
	@Autowired
	private IProductoXReservaService productoXReservaService;

	/**
	 * Este metodo se encarga asignar una ruta al metodo, 
	 * este metodo devolvera una lista de relaciones entre producto y reserva segun el id
	 *
	 * @param id es el id de productosXReserva.
	 * @return Un listadp de relaciones ProductoXReserva
	 */
	@GetMapping("/productosXReserva/{id}")
	public ResponseEntity<List<ProductoXReserva>> getProductosXReserva(@PathVariable("id") Long id) {
		return productoXReservaService.getProductosXReserva(id);

	}

	/**
	 * Este metodo se encarga asignar una ruta al metodo,
	 * este metodo devolvera una lista de productos segun el id
	 *
	 * @param id the id
	 * @return Un listadp de productos
	 */
	@GetMapping("/productosDeReserva/{id}")
	public ResponseEntity<List<Producto>> getProductosDeReserva(@PathVariable("id") Long id) {

		return productoXReservaService.getProductosDeReserva(id);
	}

	/**
	 * Este metodo se encarga asignar una ruta al metodo,
	 * este metodo asignara un producto a una reserva.
	 *
	 * @param pr es la relacion entre el producto y la reserva
	 * @return la relacion pr
	 */
	@PostMapping("/addProductoToReserva")
	public ResponseEntity<ProductoXReserva> addProductoToReserva(@RequestBody ProductoXReserva pr) {
		return productoXReservaService.addProductToReserva(pr);

	}

	/**
	 * Este metodo se encarga asignar una ruta al metodo,
	 * este metodo borra un producto de una reserva.
	 *
	 * @param id de la relacion
	 * @return the response entity
	 */
	@DeleteMapping("/deleteProductoFromReserva/{id}")
	public ResponseEntity<ProductoXReserva> deleteProductoFromReserva(@PathVariable("id") Long id) {
		return productoXReservaService.deleteProductoFromReserva(id);
	}
}
