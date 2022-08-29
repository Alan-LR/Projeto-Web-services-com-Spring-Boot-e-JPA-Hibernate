package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.entities.Order;
import com.example.demo.entities.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository prodRep;

    public List<Product> findAll() {
        return prodRep.findAll();
    }

    public Optional<Product> findById(Long id) {
        return prodRep.findById(id);

    }

}
