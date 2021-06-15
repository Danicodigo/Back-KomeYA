package com.komeya.jpa.interfaceservice;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.komeya.jpa.modelo.Producto;

/**
 * The Interface IProductoService.
 */
public interface IProductoService {
	
	/**
	 * Metodo abstracto que devuelve un listado de productos
	 *
	 * @return the productos
	 */
	public ResponseEntity<List<Producto>> getProductos();
	
	/**
	 * Metodo abstracto que crea un producto
	 *
	 * @param producto a crear
	 * @return the response entity
	 */
	public ResponseEntity<Producto> createProducto(Producto producto);
	
	/**
	 * Metodo abstracto que  borra un producto por la id.
	 *
	 * @param id del producto
	 * @return the response entity
	 */
	public ResponseEntity<Producto> deleteProducto(Long id);
	
	/**
	 *Metodo abstracto que devuelve un producto a partir de la id
	 *
	 * @param id del producto
	 * @return the producto
	 */
	ResponseEntity<Producto> getProducto(Long id);
	
	/**
	 * Metodo abstracto que actualiza un producto
	 *
	 * @param id del producto
	 * @param producto
	 * @return producto actualizado
	 */
	ResponseEntity<Producto> updateProducto(Long id, Producto producto);

}
