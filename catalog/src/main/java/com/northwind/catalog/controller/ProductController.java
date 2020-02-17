package com.northwind.catalog.controller;

import com.northwind.catalog.model.Products;
import com.northwind.catalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("/getAll")
    public List<Products> getAll(){
        return repository.findAll();
    }
}
