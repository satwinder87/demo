package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.ProductId;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product saveProduct(Product product){
        return repository.save(product);
    }

    public List<Product> findProductByType(String type){
        return repository.findProductByType(type);
    }

    public Optional<Product> findByProductId(ProductId id){
        return repository.findById(id);
    }

    public List<Product> findProductById(String id){
        return repository.findProductByProductId(id);
    }

    public Optional<Product> findProductByIdAndLatestVersion(String id){
        return repository.findProductByIdAndLatestVersion(id);
    }

}
