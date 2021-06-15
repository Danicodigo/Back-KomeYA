package com.komeya.jpa.controler;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.komeya.jpa.interfaceservice.IProductoService;
import com.komeya.jpa.modelo.Producto;


/**
 * Clase del controlador de Productos, se encarga de establecer las rutas de los servicios de los productos.
 * 
 * @author Dani Kuradchyk
 * @version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping()
public class ProductoController {
	
	/** Producto service. se encarga de proveer los servicios al controlador*/
	@Autowired
	private IProductoService productoService;
	
	
	/**
	 * Este metodo se encarga asignar una ruta al metodo, 
	 * este metodo devolvera una lista de todos los productos
	 *
	 * @return Un listadp de productos
	 */
	@GetMapping("/productos")
	public ResponseEntity<List<Producto>> getProductos(){
		return productoService.getProductos();
		
	}
	
	/**
	 * Este metodo se encarga asignar una ruta al metodo, 
	 * este metodo devolvera un producto segun la id
	 *
	 * @param id del producto a consultar
	 * @return el producto solicitado
	 */
	@GetMapping("/producto/{id}")
	public ResponseEntity<Producto> getProducto(@PathVariable("id") Long id){
		
		return productoService.getProducto(id);
		
	}
	
	/**
	 * Este metodo se encarga asignar una ruta al metodo, 
	 * este metodo actualizara un producto pasandole el id y el producto actualizado
	 *
	 * @param id del producto a actualizar
	 * @param producto el producto actualizado
	 * @return producto actualizado
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@PatchMapping("/producto/{id}")
	  public ResponseEntity<Producto> updateProducto(@PathVariable("id") Long id, @RequestBody Producto producto) {
	   return  productoService.updateProducto(id, producto);
	  }
	
	/**
	 * Este metodo se encarga asignar una ruta al metodo, 
	 * este metodo borra un producto.
	 *
	 * @param id del producto
	 * @return the response entity
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/producto/{id}")
	public ResponseEntity<Producto> deleteProducto(@PathVariable("id") Long id){
		return productoService.deleteProducto(id);
	}
	
	/**
	 * Este metodo se encarga asignar una ruta al metodo, 
	 * este metodo crea un producto nuevo.
	 * 
	 * @param producto nuevo
	 * @return producto nuevo
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/crearProducto")
	public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
		
		return productoService.createProducto(producto);
	}

}
