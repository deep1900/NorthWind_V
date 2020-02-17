package com.northwind.inventory.controller;

import com.northwind.inventory.model.Product;
import com.northwind.inventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class ProductController
{
    @Autowired
    ProductRepository repository;
    @GetMapping("/test")
    public String test(){
        return "This is a test";
    }

    @GetMapping("/getAllInventory")
    public List<Product> findAllInventory(){

        return repository.findAll();

    }
}
