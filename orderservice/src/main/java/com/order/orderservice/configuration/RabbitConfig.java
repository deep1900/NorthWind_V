package com.order.orderservice.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
//    public static final String topicExchangeName = "OrderEvent";
//    public static final String queue = "ShippingMessage";
//
//    @Bean
//    TopicExchange exchange() {
//        return new TopicExchange(topicExchangeName);
//    }
//
//    @Bean
//	Queue queue() {
//		return new Queue(queue, false);
//	}
//    @Bean
//    Binding binding(Queue queue, TopicExchange exchange){
//        return BindingBuilder.bind(queue).to(exchange).with("OrderSipped");
//    }
public static final String orderTopicExchange = "orderEvent";
    public static final String shippingTopicExchange= "shippingEvent";


    public static final String inventoryQueue= "inventoryQueue";
    public static final String orderQueue = "orderQueue";
    public static final String shippingQueue= "shippingQueue";


    @Bean
    Queue queue(){
        return new Queue(orderQueue);
    }
    @Bean
    Queue queue1(){
        return new Queue(shippingQueue);
    }
    @Bean
    Queue queue2(){
        return new Queue(inventoryQueue);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange(orderTopicExchange);
    }
    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange(shippingTopicExchange);
    }
    @Bean
    Binding binding3(){
        return BindingBuilder.bind(queue2()).to(exchange()).with("InventoryUpdate");
    }
    @Bean
    Binding binding(){
        return BindingBuilder.bind(queue1()).to(topicExchange()).with("OrderCreated");
    }
    @Bean
    Binding binding1(){
        return BindingBuilder.bind(queue()).to(exchange()).with("OrderShipped");
    }


}