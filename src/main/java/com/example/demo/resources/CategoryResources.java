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

import com.example.demo.entities.Category;

import com.example.demo.repositories.CategoryRepository;
import com.example.demo.services.CategoryService;

@RestController
@RequestMapping(value = "/category")

// CommandLineRunner serve para executar algum comando toda vez que a aplicação
// for iniciada basta extender a classe com:
// *implements CommandLineRunner*
public class CategoryResources {

    @Autowired
    private CategoryService services;

    @Autowired
    private CategoryRepository catRep;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> result = services.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Category>> findById(@PathVariable Long id) {
        Optional<Category> result = services.findById(id);
        return ResponseEntity.ok().body(result);

    }

    // @Override
    // public void run(String... args) throws Exception {
    // Category cat1 = new Category(null, "Electronics");
    // Category cat2 = new Category(null, "Books");
    // Category cat3 = new Category(null, "Computers");

    // catRep.saveAll(Arrays.asList(cat1, cat2, cat3));
    // }

}
