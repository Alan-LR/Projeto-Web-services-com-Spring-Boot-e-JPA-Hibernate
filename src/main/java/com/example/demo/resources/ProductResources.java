package com.example.demo.resources;

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

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping(value = "/product")

// CommandLineRunner serve para executar algum comando toda vez que a aplicação
// for iniciada basta extender a classe com:
// *implements CommandLineRunner*
public class ProductResources implements CommandLineRunner {

    @Autowired
    private ProductService services;

    @Autowired
    private ProductRepository prodRep;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> result = services.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable Long id) {
        Optional<Product> result = services.findById(id);
        return ResponseEntity.ok().body(result);

    }

    @Override
    public void run(String... args) throws Exception {
        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

        prodRep.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
    }

}
