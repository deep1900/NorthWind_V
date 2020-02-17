package com.order.orderservice.mapper;


import com.order.orderservice.model.Order;
import com.order.orderservice.model.OrderItem;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    public static OrderModel toModel(Order entity) {
        OrderModel model = new OrderModel();
        model.setOrderNo(entity.getId());
        model.setCustomerNo(entity.getCustomerNo());
        model.setCompanyName(entity.getCompanyName());
        model.setOrderDate(entity.getOrderDate());
        model.setVersion(entity.getVersion());
        model.setShipAddress(entity.getShipAddress());
        model.setShipCity(entity.getShipCity());
        model.setShipCountry(entity.getShipCountry());
        model.setShipPostalCode(entity.getShipPostalCode());
        model.setShipRegion(entity.getShipRegion());
        model.setShipName(entity.getShipName());
        model.setStatus(entity.getStatus());
        model.setShippedDate(entity.getShippedDate());
        model.setItems(OrderMapper.toModelItem(entity.getItems()));
        return model;
    }

    public static List<OrderItemModel> toModelItem(List<OrderItem> items)
    {
           OrderItemModel model = new OrderItemModel();
           List<OrderItemModel> list = new ArrayList<>();
        items.stream().forEach(item->{
            model.setDiscount(item.getDiscount());
            model.setProductId(item.getId().getProductId());
            model.setProductName(item.getProductName());
            model.setQuantity(item.getQuantity());
            model.setQuantityPerUnit(item.getQuantityPerUnit());
            model.setUnitPrice(item.getUnitPrice());
            model.setVersion(item.getVersion());
            list.add(model);
        });
        return list;
    }

    public static Order toNewEntity(OrderModel model) {
        Order entity = new Order(model.getCustomerId(),
                                 model.getCustomerNo(),
                                 model.getCompanyName());

        entity.setOrderDate(new Date(model.getOrderDate().getTime()));
        entity.setShipAddress(model.getShipAddress());
        entity.setShipCity(model.getShipCity());
        entity.setShipCountry(model.getShipCountry());
        entity.setShipPostalCode(model.getShipPostalCode());
        entity.setShipRegion(model.getShipRegion());
        entity.setShipName(model.getShipName());

        model.getItems().stream().forEach(i->entity.addItem(OrderItemMapper.newEntity(entity, i)));
        return entity;
    }

    public static void merge(OrderModel model, Order entity) {
        entity.setShipAddress(model.getShipAddress());
        entity.setShipCity(model.getShipCity());
        entity.setShipCountry(model.getShipCountry());
        entity.setShipPostalCode(model.getShipPostalCode());
        entity.setShipRegion(model.getShipRegion());
        entity.setShipName(model.getShipName());
    }
}
