package com.example.demo.resources;

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

    // @Override
    // public void run(String... args) throws Exception {
    // OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
    // OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
    // OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
    // OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

    // orderItemRep.saveAll(Arrays.asList(o1, o2, o3));
    // }
}
