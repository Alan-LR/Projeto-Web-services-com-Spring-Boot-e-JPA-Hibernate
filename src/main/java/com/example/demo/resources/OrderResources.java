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
import com.example.demo.entities.User;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.OrderService;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(value = "/orders")

// CommandLineRunner serve para executar algum comando toda vez que a aplicação
// for iniciada basta extender a classe com:
// *implements CommandLineRunner*
public class OrderResources {

    @Autowired
    private UserRepository userRep;

    @Autowired
    private OrderRepository orderRep;

    @Autowired
    private OrderService services;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {
        List<Order> result = services.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Order>> findById(@PathVariable Long id) {
        Optional<Order> result = services.findById(id);
        return ResponseEntity.ok().body(result);

    }

    // @Override
    // public void run(String... args) throws Exception {
    // Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),
    // userRep.getReferenceById((long) 1));
    // Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),
    // userRep.getReferenceById((long) 2));
    // Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),
    // userRep.getReferenceById((long) 1));

    // orderRep.saveAll(Arrays.asList(o1, o2, o3));
    // }
}
