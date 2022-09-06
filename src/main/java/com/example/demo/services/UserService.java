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

    public User update(Long id, User obj) {
        User entity = userRep.getReferenceById(id);
        updateData(entity, obj);
        return userRep.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
