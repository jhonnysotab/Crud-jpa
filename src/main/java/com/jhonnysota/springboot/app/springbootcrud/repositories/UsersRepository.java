package com.jhonnysota.springboot.app.springbootcrud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.jhonnysota.springboot.app.springbootcrud.entities.User;

public interface UsersRepository  extends CrudRepository<User,Long>{

}
