package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRep;

    public List<User> findAll() {
        return userRep.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRep.findById(id);

    }

    public User insert(User obj) {
        return userRep.save(obj);
    }

    public void delete(Long id) {
        userRep.deleteById(id);
    }

}
