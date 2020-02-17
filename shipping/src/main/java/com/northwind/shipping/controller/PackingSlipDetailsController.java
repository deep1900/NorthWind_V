package com.northwind.shipping.controller;

import com.northwind.shipping.mapping.PackingSlipDetailsModel;
import com.northwind.shipping.service.PackingSlipDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/packingSlipsDetails")
public class PackingSlipDetailsController
{
    @Autowired
    PackingSlipDetailService service;

    @GetMapping("/test")
    public String test(){
        return "Hello PackingSlipsController";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PackingSlipDetailsModel>> getAll(){
        List<PackingSlipDetailsModel> packingSlipDetailsModels = service.findAllSlipDetails();
        return ResponseEntity.ok(packingSlipDetailsModels);
    }
}
