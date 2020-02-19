package com.northwind.customerservice.controller;

import com.northwind.customerservice.mapper.address.AddressMapper;
import com.northwind.customerservice.mapper.address.AddressModel;
import com.northwind.customerservice.mapper.customer.CustomerMapper;
import com.northwind.customerservice.mapper.customer.CustomerModel;
import com.northwind.customerservice.model.Address;
import com.northwind.customerservice.model.Customer;
import com.northwind.customerservice.model.Order;
import com.northwind.customerservice.repository.AddressRepository;
import com.northwind.customerservice.repository.CustomerRepository;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerRepository repository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    AddressRepository addressRepository;

    @GetMapping("/test")
    public String test() {
        return "Hello Customer";
    }

    @GetMapping("/getAllCustomer")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customerList = repository.findAll();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @PostMapping("/addCustomer")
    @Transactional
    public ResponseEntity<String> addCustomer(@RequestBody @ApiParam Customer customer) {
        Customer customer1 = customer;
        Customer abc = repository.save(customer1);
        System.out.println(abc);
        return new ResponseEntity<>("Customer is saved" + abc, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<CustomerModel> findById(@PathVariable @ApiParam long id) {
        Optional<Customer> customer = repository.findById(id);
        if (!customer.isPresent()) ResponseEntity.notFound().build();
        return ResponseEntity.ok(CustomerMapper.toModel(customer.get()));
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<String> deleteById(@PathVariable @ApiParam long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("Customer is Deleted", HttpStatus.OK);
    }

    @GetMapping("/getAllCustomer/getAddress/{id1}")
    public ResponseEntity<AddressModel> findByCustomerId(@PathVariable @ApiParam long id1) {
        ResponseEntity<AddressModel> responseEntity = null;
        Optional<Customer> customer = repository.findById(id1);
        if (!customer.isPresent()) {
            ResponseEntity.notFound().build();
        } else {
            long id = customer.get().getId();
            Optional<Address> address = addressRepository.findById(id);
            if (!address.isPresent()) {
                ResponseEntity.notFound().build();
            } else {
                System.out.println("System out is" + AddressMapper.toModel(address.get()));
                responseEntity = ResponseEntity.ok(AddressMapper.toModel(address.get()));
            }
        }
        return responseEntity;
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<CustomerModel> updateCustomer(@RequestBody @ApiParam  Customer customer){
        Optional<Customer> fetchCustomer = repository.findById(customer.getId());
        if(!fetchCustomer.isPresent()){
            repository.save(customer);
        }
        else{
                int version;
                version = fetchCustomer.get().getVersion();
                version ++;
                fetchCustomer.get().setVersion(version);
                customer.setVersion(version);
                repository.save(customer);
            System.out.println("Customer is "+CustomerMapper.toModel(fetchCustomer.get()));
        }
        return ResponseEntity.ok(CustomerMapper.toModel(fetchCustomer.get()));

    }

    @GetMapping("/orderHistroy/{customerId}")
    public List<Order> orderHistroy(@PathVariable long customerId){


     //   String id1 = String.valueOf(id);

        String URL = "http://order-service:8083/order/histroy";

        ResponseEntity<Order[]> o = restTemplate.getForEntity(URL+"/"+customerId, Order[].class);
        Order[] order = o.getBody();
        List<Order> list = Arrays.asList(order);
      list.stream().forEach(x-> System.out.println("LIST IS"+x.getOrderNo()));
        return list;
    }
}

