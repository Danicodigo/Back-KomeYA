package com.komeya.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.komeya.jpa.interfaceService.IProductoService;
import com.komeya.jpa.interfaceService.IProductoXReservaService;
import com.komeya.jpa.interfaces.IProducto;
import com.komeya.jpa.interfaces.IProductoXReserva;
import com.komeya.jpa.modelo.Producto;
import com.komeya.jpa.modelo.ProductoXReserva;
import com.komeya.jpa.modelo.Reserva;
@Service
public class ProductoXReservaService implements IProductoXReservaService{
	@Autowired
	IProductoXReserva productoxreserva;
	
	@Autowired
	IProductoService productos;
	
	@Override
	public ResponseEntity<List<ProductoXReserva>> getProductosXReserva() {
		try {
		      List<ProductoXReserva> productoxreservaa = new ArrayList<ProductoXReserva>();

		     
		      productoxreserva.findAll().forEach(productoxreservaa::add);
		   

		      if (productoxreservaa.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(productoxreservaa, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}



	@Override
	public ResponseEntity<ProductoXReserva>addProductToReserva(ProductoXReserva r) {
		// TODO Auto-generated method stub
		 try {
			 ProductoXReserva productoxreservaa = productoxreserva.save(r);
		      return new ResponseEntity<>(productoxreservaa, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}

	@Override
	public ResponseEntity<ProductoXReserva> deleteProductoFromReserva(Long id) {
		  try {
			  productoxreserva.deleteById(id);
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		    }	
	}



	@Override
	public ResponseEntity<List<Producto>> getProductosDeReserva(Long id) {
		try {
		      List<ProductoXReserva> productoxreservaa = new ArrayList<ProductoXReserva>();
		      List<Producto>productos= new ArrayList<Producto>();
		      
		      productoxreserva.findProductsByReserva(id).forEach(productoxreservaa::add);
		      
		      
		      for(ProductoXReserva oxp : productoxreservaa) {
					ResponseEntity<Producto> pw = this.productos.getProducto(oxp.getId());
					productos.add(pw.getBody());
					
				}
		      if (productoxreservaa.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(productos, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		
	}

}
