package com.example.demo.rest;

import com.example.demo.mapper.SimplePojoToModelMapper;
import com.example.demo.model.Customer;
import com.example.demo.pojo.CreateCustomerRequest;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1")
public class DemoController {

    private final DemoService service;

    private final SimplePojoToModelMapper mapper;

    @Autowired
    public DemoController(DemoService service, SimplePojoToModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(value = "sayHello")
    public ResponseEntity<String> sayHello() {
        System.out.println("Received Hello Request");
        return ResponseEntity.ok("Hello World !");
    }

    @PostMapping(value = "createCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody CreateCustomerRequest request) {
        System.out.println("Received CreateCustomer Request : " + request.getEmail());

        Customer saved = service.saveCustomer(mapper.fromCreateCustomerRequest(request));

        saved.add(WebMvcLinkBuilder.linkTo(DemoController.class).slash(saved.getId()).withSelfRel());

        return ResponseEntity.ok(saved);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customerOptional = service.getCustomer(id);
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            customer.add(WebMvcLinkBuilder.linkTo(DemoController.class).slash(customer.getId()).withSelfRel());
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @GetMapping(value = "getCustomers")
    public ResponseEntity<List<Customer>> getCustomers() {

        List<Customer> customers = service.getCustomers();

        customers.forEach(customer -> customer.add(WebMvcLinkBuilder.linkTo(DemoController.class).slash(customer.getId()).withSelfRel()));

        return ResponseEntity.ok(customers);
    }
}
