package com.northwind.shipping;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com/northwind/shipping")
public class ShippingApplication {


	public static void main(String[] args) {
		SpringApplication.run(ShippingApplication.class, args);
	}

}
