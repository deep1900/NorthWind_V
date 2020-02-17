package com.northwind.catalog.controller;

import com.northwind.catalog.model.ProductImages;
import com.northwind.catalog.repository.ProductImageRepository;
import com.northwind.catalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/image")
public class ProductImageController {
    @Autowired
    private ProductImageRepository repository;

    @GetMapping("/getAll")
    public List<ProductImages> getAll(){
        return repository.findAll();
    }
}
