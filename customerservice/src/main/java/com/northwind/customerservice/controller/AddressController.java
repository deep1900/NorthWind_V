package com.northwind.customerservice.controller;

import com.northwind.customerservice.mapper.address.AddressMapper;
import com.northwind.customerservice.mapper.address.AddressModel;

import com.northwind.customerservice.model.Address;


import com.northwind.customerservice.rabbitmq.Receiver;
import com.northwind.customerservice.repository.AddressRepository;
import com.northwind.customerservice.repository.CustomerRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/address")
public class AddressController
{
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private  RabbitTemplate rabbitTemplate;
    @Autowired
    private  Receiver receiver;
    @Autowired
    private TopicExchange topicExchange;

    @GetMapping("/test")
    public String test() throws InterruptedException {
        rabbitTemplate.convertAndSend(topicExchange.getName(), "foo.bar.baz", "Hello, Rabbit World from Controller");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        return "Hello Address";
    }
    @GetMapping("/getAll")
public List<Address> getAllAddress() throws InterruptedException {
        List<Address> allAddress= addressRepository.findAll();
        rabbitTemplate.convertAndSend(topicExchange.getName(), "foo.bar.baz", allAddress.toString());
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        return allAddress;
}
    @GetMapping("/getAddress/{id}")
    public ResponseEntity<AddressModel> findById(@PathVariable @ApiParam long id) throws InterruptedException {
        Optional<Address> address = addressRepository.findById(id);
        if(!address.isPresent()) ResponseEntity.notFound().build();
        ResponseEntity<AddressModel> ok = ResponseEntity.ok(AddressMapper.toModel(address.get()));
        rabbitTemplate.convertAndSend(topicExchange.getName(), "foo.bar.baz", AddressMapper.toModel((address.get())));
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);

        return ok;
    }
    @PutMapping("/updateAddress")
    public ResponseEntity<AddressModel> updateAddress(@RequestBody @ApiParam Address address){
        Optional<Address> fetchAddress = addressRepository.findById(address.getAddressId());
        if(!fetchAddress.isPresent()){
            addressRepository.save(address);
        }
        else{
            int version = fetchAddress.get().getVersion();
            version ++;
            fetchAddress.get().setVersion(version);
            address.setVersion(version);
            addressRepository.save(address);
        }
        return ResponseEntity.ok(AddressMapper.toModel(fetchAddress.get()));
    }




}
