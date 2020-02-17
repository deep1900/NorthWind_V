package com.order.orderservice.mapper;


import com.order.orderservice.model.Order;
import com.order.orderservice.model.OrderItem;

public class OrderItemMapper {

    public static OrderItemModel toModel(OrderItem entity) {
        OrderItemModel model = new OrderItemModel();
        model.setDiscount(entity.getDiscount());
        model.setProductId(entity.getId().getProductId());
        model.setProductName(entity.getProductName());
        model.setQuantity(entity.getQuantity());
        model.setQuantityPerUnit(entity.getQuantityPerUnit());
        model.setUnitPrice(entity.getUnitPrice());
        model.setVersion(entity.getVersion());
        return model;
    }

    public static OrderItem newEntity(Order order, OrderItemModel model) {
        OrderItem entity = new OrderItem(order, model.getProductId());
        entity.setDiscount(model.getDiscount());
        entity.setProductName(model.getProductName());
        entity.setQuantity(model.getQuantity());
        entity.setQuantityPerUnit(model.getQuantityPerUnit());
        entity.setUnitPrice(model.getUnitPrice());
        return entity;
    }
}
