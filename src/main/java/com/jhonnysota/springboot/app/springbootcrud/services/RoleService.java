package com.jhonnysota.springboot.app.springbootcrud.services;
import java.util.Optional;
import com.jhonnysota.springboot.app.springbootcrud.entities.Role;


public interface RoleService{

    Optional<Role> findByName(String string);

}
