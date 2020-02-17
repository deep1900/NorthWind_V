package com.order.orderservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.order.orderservice.mapper.OrderMapper;
import com.order.orderservice.mapper.OrderModel;
import com.order.orderservice.model.Order;
import com.order.orderservice.model.OrderStatus;
import com.order.orderservice.repository.OrderRepository;
import com.order.orderservice.service.OrderService;
import io.swagger.annotations.ApiParam;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController
{
    @Autowired
    private OrderService service;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    OrderRepository repository;



    @GetMapping("/getAll")
    public List<OrderModel> getAll(){
        List<Order>  orderList = repository.findAll();
        List<OrderModel> orderModelList = orderList.stream().map(o-> OrderMapper.toModel(o)).collect(Collectors.toList());
        rabbitTemplate.convertAndSend("OrderEvent","foo.bar.#","Hehehe");
        return orderModelList;
    }
    @Transactional
    @PostMapping("/addOrder")
    public ResponseEntity<OrderModel> create(@ApiParam@RequestBody OrderModel model) throws JsonProcessingException {
        if (model.getItems() == null || model.getItems().size() == 0) {
            return ResponseEntity.unprocessableEntity().build();
        }
        Order order = OrderMapper.toNewEntity(model);
        OrderStatus status = OrderStatus.valueOf("Processing");
        order.setStatus(status);
        OrderModel savedOrder =
                OrderMapper.toModel(service.save(order));
        return ResponseEntity.created(URI.create("/orders/" + order.getId()))
                .body(savedOrder);
    }

    @GetMapping("/histroy/{id}")
    public List<OrderModel> getOrderbyCustomerId(@ApiParam @PathVariable long id){
        List<Order> order = service.getCustomer(id);
        List<OrderModel> model = order.stream().map(order1->OrderMapper.toModel(order1)).collect(Collectors.toList());
        return model;
    }
}
