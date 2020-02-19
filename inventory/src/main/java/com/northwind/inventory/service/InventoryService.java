package com.northwind.inventory.service;

import com.google.gson.Gson;
import com.northwind.inventory.model.Product;
import com.northwind.inventory.repository.ProductRepository;
import org.hibernate.criterion.Order;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private ProductRepository repository;


    //Listing a queue.
    @RabbitListener(queues = "inventoryQueue")
    public void notification(String message) {
        Gson g = new Gson();
        OrderItem[] items1 = g.fromJson(message, OrderItem[].class);
        List<OrderItem> items = Arrays.asList(items1);
        Product product = new Product();
        //Itrating through the Message we got from product.
        items.stream().forEach(x -> {
            Optional<Product> product1 = repository.findByProductName(x.getProductName()); //finding product form datebase
            if(product1.isPresent()){
                int quantity_on_Order = x.getQuantity();
                int inStock = product1.get().getUnitsInStock();
                int newInStock = quantity_on_Order - inStock;   //update the Quantity.
                product1.get().setUnitsInStock(newInStock);
                repository.save(product1.get());   //Persist the Quantity.
            }
        });
    }
}
