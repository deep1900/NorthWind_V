package com.order.orderservice.controller;

import com.order.orderservice.mapper.OrderItemModel;
import com.order.orderservice.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderDetails")
public class OrderDetailsController {

    @Autowired
    OrderDetailsService service;
    @GetMapping("/test")
    public String test(){
        return "Hello OrderDetails";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<OrderItemModel>> getAll(){
      List<OrderItemModel> model = service.getAll();
      return ResponseEntity.ok(model);
    }
}
