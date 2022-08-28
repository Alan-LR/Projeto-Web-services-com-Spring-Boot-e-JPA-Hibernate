package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.UserAPI;

public interface UserRepository extends JpaRepository<UserAPI, Long> {

}
