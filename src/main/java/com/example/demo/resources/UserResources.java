package com.example.demo.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.UserAPI;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.Services;

@RestController
@RequestMapping(value = "/users")

// CommandLineRunner serve para executar algum comando toda vez que a aplicação
// for iniciada basta extender a classe com:
// *implements CommandLineRunner*
public class UserResources {

    @Autowired
    private UserRepository userRep;

    @Autowired
    private Services services;

    @GetMapping
    public ResponseEntity<List<UserAPI>> findAll() {
        List<UserAPI> result = services.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<UserAPI>> findById(@PathVariable Long id) {
        Optional<UserAPI> result = services.findById(id);
        return ResponseEntity.ok().body(result);

    }

    // @Override
    // public void run(String... args) throws Exception {
    // UserAPI u1 = new UserAPI(null, "Maria Brown", "maria@gmail.com", "988888888",
    // "123456");
    // UserAPI u2 = new UserAPI(null, "Alex Green", "alex@gmail.com", "977777777",
    // "123456");

    // userRep.saveAll(Arrays.asList(u1, u2));
    // }
}
