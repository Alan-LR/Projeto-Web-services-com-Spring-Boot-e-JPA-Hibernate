package com.example.demo.resourcesController;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Order;
import com.example.demo.entities.OrderItem;
import com.example.demo.entities.User;
import com.example.demo.entityEnum.OrderStatus;
import com.example.demo.repositories.OrderItemRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.OrderItemService;
import com.example.demo.services.OrderService;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(value = "/orderItem")

// CommandLineRunner serve para executar algum comando toda vez que a aplicação
// for iniciada basta extender a classe com:
// *implements CommandLineRunner*
public class OrderItemResources {

    @Autowired
    private UserRepository userRep;

    @Autowired
    private OrderRepository orderRep;

    @Autowired
    private OrderItemService services;

    @Autowired
    private OrderItemRepository orderItemRep;

    @GetMapping
    public ResponseEntity<List<OrderItem>> findAll() {
        List<OrderItem> result = services.findAll();
        return ResponseEntity.ok().body(result);
    }

    // @GetMapping("{id}")
    // public ResponseEntity<Optional<OrderItem>> findById(@PathVariable Long id) {
    // Optional<OrderItem> result = services.findById(id);
    // return ResponseEntity.ok().body(result);

    // }

}
