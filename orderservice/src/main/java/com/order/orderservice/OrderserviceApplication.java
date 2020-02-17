package com.order.orderservice;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan("com/order/orderservice")
public class OrderserviceApplication {

	static final String queueName = "orderQueue";
	public static final  String topicExchangeName ="OrderEvent";

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}


	@Bean
	TopicExchange exchange() {
		return new TopicExchange(topicExchangeName);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange){
		return BindingBuilder.bind(queue).to(exchange).with("orderCreated");
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderserviceApplication.class, args);


	}

}



//	@Bean
//	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
//											) {
//		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//		container.setConnectionFactory(connectionFactory);
//		container.setQueueNames(queueName);
//		return container;
//	}
//
//	@Bean
//	MessageListenerAdapter listenerAdapter(Receiver receiver) {
//		return new MessageListenerAdapter(receiver, "receiveMessage");
//	}