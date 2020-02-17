package com.northwind.catalog.controller;

import com.northwind.catalog.model.Catagories;
import com.northwind.catalog.repository.CatagoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catagory")
public class CatagoriesController {
    @Autowired
    private CatagoryRepository  repository;

    @GetMapping
    public List<Catagories> getAll(){return repository.findAll();}
}
