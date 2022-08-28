package com.example.demo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.UserAPI;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @GetMapping
    public ResponseEntity<UserAPI> findAll() {
        UserAPI u = new UserAPI(1L, "Maria", "maria@gmail.com", "9999-9999", "12345");
        return ResponseEntity.ok().body(u);
    }
}
