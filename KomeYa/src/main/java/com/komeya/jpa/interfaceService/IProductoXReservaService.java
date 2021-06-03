package com.komeya.jpa.interfaceService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.komeya.jpa.modelo.Producto;
import com.komeya.jpa.modelo.ProductoXReserva;
import com.komeya.jpa.modelo.Reserva;

public interface IProductoXReservaService {
	public ResponseEntity<ProductoXReserva> addProductToReserva(ProductoXReserva productXReserva);
	ResponseEntity<ProductoXReserva> deleteProductoFromReserva(Long id);
	ResponseEntity<List<Producto>> getProductosDeReserva(Long id);
	ResponseEntity<List<ProductoXReserva>> getProductosXReserva(Long id);
}
