package com.northwind.shipping.controller;


import com.northwind.shipping.mapping.PackingSlipsModel;
import com.northwind.shipping.model.PackingSlips;

import com.northwind.shipping.service.PackingSlipService;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/packingslips")
@RestController
public class PackingSlipController {

    @Autowired
    PackingSlipService service;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    TopicExchange topicExchange;

    @GetMapping("/test")
    public String test() {
        return "Hello PackingSlips";
    }

    @GetMapping("/getAllPackingSlips")
    public ResponseEntity<List<PackingSlipsModel>> getAll() {
        List<PackingSlipsModel> packingSlips = service.findAllSlips();
        return ResponseEntity.ok(packingSlips);
    }

    @GetMapping("/shipEvent/{id}")
    public String Shipped(@PathVariable long id){
      Optional<PackingSlips> packingSlipsOptional =   service.findById(id);
        if(packingSlipsOptional.isPresent()){
           long number =  packingSlipsOptional.get().getOrderId();
           String orderid = new String(String.valueOf(number));
            rabbitTemplate.convertAndSend(topicExchange.getName(),"OrderShipped", orderid);
            return "Message Sent to OrderService";
        }
        else {
            return "There is no such Order";
        }
    }
}
