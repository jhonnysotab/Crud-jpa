package com.jhonnysota.springboot.app.springbootcrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhonnysota.springboot.app.springbootcrud.entities.Product;
import com.jhonnysota.springboot.app.springbootcrud.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    @Transactional
    public Optional<Product> delete(Long id) {
        Optional<Product> product2 = repository.findById(id);
        product2.ifPresent(pro->{
            repository.delete(pro);
        });
        return product2;
    }

    @SuppressWarnings("null")
    @Transactional(readOnly = true)
    public Optional<Product> findByAll(Long id) {
        return repository.findById(id);
    }

    @SuppressWarnings("null")
    @Override
    public Product save(Product product) {
        return repository.save(product);

    }
    @Transactional
    @Override
    public Optional<Product> update(Long id,Product product) {
        Optional<Product> product2 = repository.findById(id);
        if(product2.isPresent()){
            Product pro = product2.orElseThrow();
            pro.setName(product.getName()== null ? pro.getName(): product.getName());
            pro.setDescription(product.getDescription()== null ? pro.getDescription(): product.getDescription());
            pro.setPrice(product.getPrice()== 0 ? pro.getPrice(): product.getPrice());
            pro.setCantidad(product.getCantidad()== 0 ? pro.getCantidad(): product.getCantidad());
           return Optional.of(repository.save(pro));
        }
        return product2;

    }
}
