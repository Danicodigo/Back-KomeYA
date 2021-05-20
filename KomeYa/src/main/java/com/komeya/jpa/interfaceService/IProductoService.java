package com.komeya.jpa.interfaceService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.komeya.jpa.modelo.Producto;


public interface IProductoService {
	public ResponseEntity<List<Producto>> getProductos();
	public ResponseEntity<Producto> createProducto(Producto r);
	public ResponseEntity<Producto> deleteProducto(Long id);
	ResponseEntity<Producto> getProducto(Long id);
	ResponseEntity<Producto> updateProducto(Long id, Producto tutorial);

}
