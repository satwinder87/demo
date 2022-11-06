package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.model.Customer_;
import com.example.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemoService {
    private DemoRepository repository;

    @Autowired
    public DemoService(DemoRepository repository) {
        this.repository = repository;
    }

    public Customer saveCustomer(final Customer customer) {
        return repository.save(customer);
    }

    public List<Customer> getCustomers(){
        return repository.findAll(Sort.by(Customer_.NAME));
    }

    public Optional<Customer> getCustomer(Long id){
       return repository.findById(id);
    }
}
