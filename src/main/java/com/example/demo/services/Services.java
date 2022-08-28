package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.UserAPI;
import com.example.demo.repositories.UserRepository;

@Service
public class Services {

    @Autowired
    private UserRepository userRep;

    public List<UserAPI> findAll() {
        return userRep.findAll();
    }

    public Optional<UserAPI> findById(Long id) {
        return userRep.findById(id);

    }

}
