package com.komeya.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.yaml.snakeyaml.util.ArrayUtils;

import com.komeya.jpa.exceptions.InvalidImageExtensionException;
import com.komeya.jpa.exceptions.InvalidImageSizeException;
import com.komeya.jpa.exceptions.ProductoNotFoundException;
import com.komeya.jpa.interfaceService.IProductoService;
import com.komeya.jpa.interfaces.IProducto;
import com.komeya.jpa.interfaces.IReserva;
import com.komeya.jpa.modelo.Producto;
import com.komeya.jpa.modelo.Usuario;
@Service
public class ProductoService implements IProductoService{

	@Autowired
	private IProducto productos;
	
	@Override
	public ResponseEntity<List<Producto>> getProductos() {
		try {
		      List<Producto> productoss = new ArrayList<Producto>();

		     
		    	  productos.findAll().forEach(productoss::add);
		   

		      if (productoss.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(productoss, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}

	@Override
	  public ResponseEntity<Producto> updateProducto( Long id,  Producto producto) {
	    Optional<Producto> tutorialData = productos.findById(id);

	    if (tutorialData.isPresent()) {
	      Producto _producto = tutorialData.get();
	      _producto.setNombre(producto.getNombre());
	      _producto.setDescripcion(producto.getDescripcion());
	      _producto.setDisponible(producto.isDisponible());
	      _producto.setImagenProducto(producto.getImagenProducto());
	      _producto.setPrecio(producto.getPrecio());
	      _producto.setTipoProducto(producto.getTipoProducto());
	      return new ResponseEntity<>(productos.save(_producto), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	@Override
	public ResponseEntity<Producto> createProducto(Producto r) {
		// TODO Auto-generated method stub
		 try {
		      Producto _producto = productos.save(r);
		      return new ResponseEntity<>(_producto, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	}

	@Override
	public ResponseEntity<Producto> getProducto(Long id) {
		 Optional<Producto> data = productos.findById(id);

		    if (data.isPresent()) {
		      return new ResponseEntity<>(data.get(), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
	}
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
