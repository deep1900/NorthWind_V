package com.northwind.shipping.service;


import com.fasterxml.jackson.core.JsonProcessingException;

import com.google.gson.Gson;
import com.northwind.shipping.mapping.PackingSlipMapper;
import com.northwind.shipping.mapping.PackingSlipsModel;
import com.northwind.shipping.model.PackingSlips;
import com.northwind.shipping.model.PackingSlipsDetails;
import com.northwind.shipping.ordermodel.Order;

import com.northwind.shipping.repository.PackingSlipDetailsRepository;
import com.northwind.shipping.repository.PackingSlipRepository;

import org.springframework.amqp.core.Binding;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PackingSlipService
{
    @Autowired
    PackingSlipDetailsRepository packingSlipDetailsRepository;

    @Autowired
    PackingSlipRepository repository;

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    TopicExchange topicExchange;
    @Autowired
    Binding binding;


    public List<PackingSlipsModel> findAllSlips()
    {
        List<PackingSlips> packingSlips = repository.findAll();
        List<PackingSlipsModel> packingSlipsModels = packingSlips.stream()
                .map(p-> PackingSlipMapper.toModel(p))
                .collect(Collectors.toList());
        return packingSlipsModels;
    }

    @RabbitListener(queues = "orderQueue")
    public void notification(String message) throws JsonProcessingException {
     //   ObjectMapper mapper = new ObjectMapper();
        Gson g = new Gson();
        Order order = g.fromJson(message, Order.class);
        System.out.println("Order is" +order);
        System.out.println("Message Received" + message);
        PackingSlips packingSlips = new PackingSlips();
        packingSlips.setOrderId(Long.parseLong(order.getOrderNo()));
        packingSlips.setShipAddress(order.getShipAddress());
        packingSlips.setShipCity(order.getShipCity());
        packingSlips.setShipCountry(order.getShipCountry());
        packingSlips.setShipName(order.getShipName());
        packingSlips.setShipPostalCode(order.getShipPostalCode());
        packingSlips.setShipRegion(order.getShipRegion());
       List<PackingSlipsDetails> detailslist = new ArrayList<>();
        PackingSlipsDetails details = new PackingSlipsDetails();
        order.getItems().stream().forEach(detail->{
            details.setProductName(detail.getProductName());
            int quantity = Integer.parseInt(detail.getQuantity());
            details.setId(details.getId());
            details.setQuantity(quantity);
            detailslist.add(details);
            packingSlips.addItem(details);
        });
        String orderid = String.valueOf(packingSlips.getOrderId());
//        rabbitTemplate.convertAndSend(topicExchange.getName(),"OrderProcessing", orderid);
       packingSlips.setPackingSlipsDetails(detailslist);
        repository.save(packingSlips);

    }

    public Optional<PackingSlips> findById(long id){

           return repository.findById(id);
    }

    }

