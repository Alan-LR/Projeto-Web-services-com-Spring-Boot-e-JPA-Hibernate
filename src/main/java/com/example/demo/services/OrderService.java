package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Order;

import com.example.demo.repositories.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRep;

    public List<Order> findAll() {
        return orderRep.findAll();
    }

    public Optional<Order> findById(Long id) {
        return orderRep.findById(id);

    }

}
