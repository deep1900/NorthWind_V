package com.order.orderservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.orderservice.model.Order;
import com.order.orderservice.model.OrderItem;
import com.order.orderservice.model.OrderStatus;
import com.order.orderservice.repository.OrderRepository;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private TopicExchange topicExchange;
    @Autowired
    ObjectMapper objectMapper;
    private OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }


    public Order save(Order entity) throws JsonProcessingException {
        repository.saveAndFlush(entity);
      String sendObject =   objectMapper.writeValueAsString(entity);
      rabbitTemplate.convertAndSend("orderEvent", "OrderCreated", sendObject);
      List<OrderItem> items = entity.getItems();
      String sendItems = objectMapper.writeValueAsString(items);
      rabbitTemplate.convertAndSend("orderEvent","InventoryUpdate",sendItems);


        return entity;
    }

    @RabbitListener(queues = "orderQueue")
    public void updateOrder(String message){
        long id = Long.parseLong(message);
        Optional<Order> order = repository.findById(id);
        System.out.println("MESSAGE IS " + message);
        if(order.isPresent()){
            OrderStatus status = OrderStatus.valueOf("Shipped");
            order.get().setStatus(status);
            repository.save(order.get());
        }
        else
        {
            System.out.println("No order exists");
        }




    }


    public List<Order> getCustomer(long id)
    {
            List<Order> orders = repository.findOrderbyCustomerId(id);
            return orders;
    }
}
