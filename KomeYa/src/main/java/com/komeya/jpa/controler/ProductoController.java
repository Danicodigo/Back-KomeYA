package com.komeya.jpa.controler;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.komeya.jpa.interfaceService.IProductoService;
import com.komeya.jpa.interfaceService.IReservaService;
import com.komeya.jpa.interfaceService.IUsuarioService;
import com.komeya.jpa.modelo.Producto;
import com.komeya.jpa.modelo.Reserva;
import com.komeya.jpa.modelo.Usuario;

@CrossOrigin(origins="http://localhost:8100")
@RestController
@RequestMapping()
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	
	@GetMapping("/productos")
	public ResponseEntity<List<Producto>> getProductos(){
		ResponseEntity<List<Producto>> productos=productoService.getProductos();
		return productos;
		
	}
	@GetMapping("/producto/{id}")
	public ResponseEntity<Producto> getProducto(@PathVariable("id") Long id){
		ResponseEntity<Producto> producto=productoService.getProducto(id);
		return producto;
		
	}
	@PatchMapping("/producto/{id}")
	  public ResponseEntity<Producto> updateProducto(@PathVariable("id") Long id, @RequestBody Producto producto) {
	   return (ResponseEntity<Producto>) productoService.updateProducto(id, producto);
	  }
	@DeleteMapping("/producto/{id}")
	public ResponseEntity<Producto> deleteProducto(@PathVariable("id") Long id){
		return productoService.deleteProducto(id);
	}
	
	@PostMapping("/crearProducto")
	public void crearProducto(@RequestBody Producto p) {
		
		productoService.createProducto(p);
	}

}
