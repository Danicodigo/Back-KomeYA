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

import com.komeya.jpa.interfaceService.IProductoXReservaService;
import com.komeya.jpa.modelo.Producto;
import com.komeya.jpa.modelo.ProductoXReserva;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping()
public class ProductoXReservaController {
	@Autowired
	private IProductoXReservaService productoXReservaService;
	
	
	@GetMapping("/productosXReserva")
	public ResponseEntity<List<ProductoXReserva>> getProductosXReserva(){
		ResponseEntity<List<ProductoXReserva>> productos=productoXReservaService.getProductosXReserva();
		return productos;
		
	}
	@GetMapping("/productosDeReserva/{id}")
	public ResponseEntity<List<Producto>> getProductosXReserva( @PathVariable("id") Long id){
		
		ResponseEntity<List<Producto>> productos=productoXReservaService.getProductosDeReserva(id);
		return productos;
		
	}
	@PostMapping("/addProductoToReserva")
	public ResponseEntity<ProductoXReserva> addProductoToReserva(@RequestBody ProductoXReserva pr){
		ResponseEntity<ProductoXReserva> producto=productoXReservaService.addProductToReserva(pr);
		return producto;
		
	}
	@DeleteMapping("/deleteProductoFromReserva/{id}")
	public ResponseEntity<ProductoXReserva> deleteProductoFromReserva(@PathVariable("id") Long id){
		return productoXReservaService.deleteProductoFromReserva(id);
	}
}
