package com.example.demo.resources;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.UserAPI;
import com.example.demo.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")

// CommandLineRunner serve para executar algum comando toda vez que a aplicação
// for iniciada
public class UserResources implements CommandLineRunner {

    @Autowired
    private UserRepository userRep;

    @GetMapping
    public ResponseEntity<UserAPI> findAll() {
        UserAPI u = new UserAPI(1L, "Maria", "maria@gmail.com", "9999-9999", "12345");
        return ResponseEntity.ok().body(u);
    }

    @Override
    public void run(String... args) throws Exception {
        UserAPI u1 = new UserAPI(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        UserAPI u2 = new UserAPI(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRep.saveAll(Arrays.asList(u1, u2));
    }
}
