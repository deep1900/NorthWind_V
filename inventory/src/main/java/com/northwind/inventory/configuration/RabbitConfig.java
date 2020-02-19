package com.northwind.inventory.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String orderTopicExchange ="orderEvent";
    public static final String inventoryQueue = "inventoryQueue";

    @Bean
    Queue queue(){
        return new Queue(inventoryQueue);

    }
    @Bean
    TopicExchange exchange(){
        return new TopicExchange(orderTopicExchange);
    }
    @Bean
    Binding binding(){
        return BindingBuilder.bind(queue()).to(exchange()).with("InventoryUpdate");
    }

}
