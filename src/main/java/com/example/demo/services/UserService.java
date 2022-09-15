package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.ServicesExceptions.DatabaseException;
import com.example.demo.services.ServicesExceptions.ResourceNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRep;

    public List<User> findAll() {
        return userRep.findAll();
    }

    public User findById(Long id) {
        Optional<User> result = userRep.findById(id);
        return result.orElseThrow(() -> new ResourceNotFoundException(id));

    }

    public User insert(User obj) {
        return userRep.save(obj);
    }

    public void delete(Long id) {
        try {
            userRep.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            // Optional<User> result = userRep.findById(id);
            // String errorStatus = "O usuário não pode ser deletado, pois possui os
            // pedidos: " + result.get().getOrders();
            throw new DatabaseException(e.getMessage());
        }

    }

    public User update(Long id, User obj) {
        try {
            User entity = userRep.getReferenceById(id);
            updateData(entity, obj);
            return userRep.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
