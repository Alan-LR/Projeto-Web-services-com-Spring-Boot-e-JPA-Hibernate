package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Order;
import com.example.demo.entities.OrderItem;
import com.example.demo.entitiesPK.OrderItemPk;
import com.example.demo.repositories.OrderItemRepository;
import com.example.demo.repositories.OrderRepository;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRep;

    public List<OrderItem> findAll() {
        return orderItemRep.findAll();
    }

    // public Optional<OrderItem> findById(OrderItemPk id) {
    // return orderItemRep.findById(id);

    // }

}
