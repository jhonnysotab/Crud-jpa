package com.jhonnysota.springboot.app.springbootcrud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jhonnysota.springboot.app.springbootcrud.entities.Role;
 
import java.util.Optional;

public interface RolesRepository extends CrudRepository<Role,   Long> {
    Optional<Role> findByName(String name);

}
