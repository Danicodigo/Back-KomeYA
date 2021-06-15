package com.komeya.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.komeya.jpa.interfaces.IProducto;
import com.komeya.jpa.interfaceservice.IProductoService;
import com.komeya.jpa.modelo.Producto;

/**
 * The Class ProductoService. La clase que gestiona los servicios de los productos
 * 
 * @author Dani Kuradchyk
 */
@Service
public class ProductoService implements IProductoService {

	/** The productos. */
	@Autowired
	private IProducto productos;

	/**
	 * Devuelve todos los productos
	 *
	 * @return the productos
	 */
	@Override
	public ResponseEntity<List<Producto>> getProductos() {
		try {
			List<Producto> productoss = new ArrayList<>();

			productos.findAll().forEach(productoss::add);

			if (productoss.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(productoss, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Actualiza un producto
	 *
	 * @param id del producto
	 * @param producto 
	 * @return producto actualizado
	 */
	@Override
	public ResponseEntity<Producto> updateProducto(Long id, Producto producto) {
		Optional<Producto> tutorialData = productos.findById(id);
		if (tutorialData.isPresent()) {
			Producto prod = tutorialData.get();
			prod.setNombre(producto.getNombre());
			prod.setDescripcion(producto.getDescripcion());
			prod.setDisponible(producto.isDisponible());
			prod.setImagenProducto(producto.getImagenProducto());
			prod.setPrecio(producto.getPrecio());
			prod.setTipoProducto(producto.getTipoProducto());
			productos.save(prod);
			return new ResponseEntity<>(prod, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Crea un producto
	 *
	 * @param r producto
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<Producto> createProducto(Producto r) {

		try {
			Producto prod = productos.save(r);
			return new ResponseEntity<>(prod, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Devuelve un producto a partir del id
	 *
	 * @param id del roducto
	 * @return the producto
	 */
	@Override
	public ResponseEntity<Producto> getProducto(Long id) {
		Optional<Producto> data = productos.findById(id);

		if (data.isPresent()) {
			return new ResponseEntity<>(data.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 *Borra un producto
	 *
	 * @param id del producto
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<Producto> deleteProducto(Long id) {
		try {
			productos.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
