package com.jhonnysota.springboot.app.springbootcrud.entities;

import com.jhonnysota.springboot.app.springbootcrud.validation.IsExistsDb;
import com.jhonnysota.springboot.app.springbootcrud.validation.IsRequired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @IsRequired
    @Size(min = 2,max = 45)
    private String name;

    @NotNull(message = "{NotNull.product.price}")
    @Min(2)
    private int price;
    
    @IsRequired 
    @Size(min = 2,max = 45)
    private String description;
    
    @NotNull(message = "{NotNull.product.cantidad}")
    @Min(2)
    private int cantidad;

    @IsExistsDb
    private String sku;


    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return int return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return int return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    /**
     * @return String return the sku
     */
    public String getsku() {
        return sku;
    }

    /**
     * @param sku the sku to set
     */
    public void setsku(String sku) {
        this.sku = sku;
    }

}
