package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.entities.Order;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.OrderRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRep;

    public List<Category> findAll() {
        return categoryRep.findAll();
    }

    public Optional<Category> findById(Long id) {
        return categoryRep.findById(id);

    }

}
