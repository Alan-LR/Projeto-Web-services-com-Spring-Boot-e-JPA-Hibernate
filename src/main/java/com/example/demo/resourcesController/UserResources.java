package com.example.demo.resourcesController;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(value = "/users")

// CommandLineRunner serve para executar algum comando toda vez que a aplicação
// for iniciada basta extender a classe com:
// *implements CommandLineRunner*
public class UserResources {

    @Autowired
    private UserRepository userRep;

    @Autowired
    private UserService services;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> result = services.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable Long id) {
        Optional<User> result = services.findById(id);
        return ResponseEntity.ok().body(result);

    }

    @PostMapping("/inserirUsuario")
    public ResponseEntity<User> insert(@RequestBody User obj) {
        obj = services.insert(obj);
        // Usamos o URI para retornar o status 201 created
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        services.delete(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
        obj = services.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    // @Override
    // public void run(String... args) throws Exception {
    // User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888",
    // "123456");
    // User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777",
    // "123456");

    // userRep.saveAll(Arrays.asList(u1, u2));
    // }
}
