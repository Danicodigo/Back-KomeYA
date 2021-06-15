package com.komeya.jpa.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.komeya.jpa.modelo.Producto;

/**
 * Esta clase sirve de repositorio de los productos
 * 
 * @author Dani Kuradchyk
 */
@Repository
public interface IProducto extends CrudRepository<Producto, Long>{

}
