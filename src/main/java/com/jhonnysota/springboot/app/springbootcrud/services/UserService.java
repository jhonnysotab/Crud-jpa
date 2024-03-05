package com.jhonnysota.springboot.app.springbootcrud.services;

import java.util.List;


import com.jhonnysota.springboot.app.springbootcrud.entities.User;
 
public interface UserService {

        List<User> findList();
        
        User save(User user);


}
