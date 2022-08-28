package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.UserAPI;

public interface UserRepository extends JpaRepository<UserAPI, Long> {

}
