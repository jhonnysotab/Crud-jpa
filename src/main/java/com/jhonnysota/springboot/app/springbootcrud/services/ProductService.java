package com.jhonnysota.springboot.app.springbootcrud.services;

import java.util.List;
import java.util.Optional;

import com.jhonnysota.springboot.app.springbootcrud.entities.Product;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findByAll(Long id);

    Product save(Product product);
    
    Optional<Product> update(Long id,Product product);

    Optional<Product> delete(Long id);

}
