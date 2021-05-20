package com.komeya.jpa.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.komeya.jpa.modelo.Producto;

@Repository
public interface IProducto extends CrudRepository<Producto, Long>{

}
