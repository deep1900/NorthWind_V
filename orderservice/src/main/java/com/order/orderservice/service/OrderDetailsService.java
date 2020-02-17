package com.order.orderservice.service;

import com.order.orderservice.mapper.OrderItemMapper;
import com.order.orderservice.mapper.OrderItemModel;
import com.order.orderservice.model.OrderItem;
import com.order.orderservice.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailsService {
    @Autowired
    OrderDetailsRepository orderDetailsRepository;
    public List<OrderItemModel> getAll(){
        List<OrderItem> orderDetails = orderDetailsRepository.findAll();
        List<OrderItemModel> orderDetailsModels = orderDetails.stream()
                .map(o-> OrderItemMapper.toModel(o))
                .collect(Collectors.toList());
        return orderDetailsModels;
    }
}
