package com.jhonnysota.springboot.app.springbootcrud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jhonnysota.springboot.app.springbootcrud.entities.Role;
import com.jhonnysota.springboot.app.springbootcrud.entities.User;
import com.jhonnysota.springboot.app.springbootcrud.repositories.RolesRepository;
import com.jhonnysota.springboot.app.springbootcrud.repositories.UsersRepository;

@Service
public class UserServiceImpl  implements UserService{

    @Autowired
    private UsersRepository repository;

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<User> findList() {
        return (List<User>) repository.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {
         Optional<Role> optionalRolUser= rolesRepository.findByName("ROLE_USER");
         List<Role> roles = new ArrayList<>();
         optionalRolUser.ifPresent(roles::add);

         if(user.isAdmin()){
             Optional<Role> optionalRoleAdmin = rolesRepository.findByName("ROLE_ADMIN");
             optionalRoleAdmin.ifPresent(roles::add);
         }

         user.setRoles(roles);
         user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

}
