package com.jhonnysota.springboot.app.springbootcrud.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhonnysota.springboot.app.springbootcrud.entities.Product;
import com.jhonnysota.springboot.app.springbootcrud.services.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping
    public List<Product> list(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> view(@PathVariable Long id){
        Optional<Product> optional = service.findByAll(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> product(@Valid  @RequestBody Product product,BindingResult result){
       if(result.hasFieldErrors()){
        return validation(result);
    }
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update( @PathVariable Long id, @Valid @RequestBody Product product, BindingResult result){
        if(result.hasFieldErrors()){
            return validation(result);
        }
        product.setId(id);  
        Optional<Product> prOptional = service.update( id,product);
        if (prOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(prOptional.get());
        }
            return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
     
        Optional<Product> prdBD= service.delete(id);
        if(prdBD.isPresent()){
            return ResponseEntity.ok().body(prdBD.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }


    private ResponseEntity<?> validation(BindingResult result) {
        Map<String,String> errors = new HashMap<>();
        result.getFieldErrors().forEach(error->{
            errors.put(error.getField(),"El Campo "+ error.getField()+" "+ error.getDefaultMessage());
        });
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }


}
