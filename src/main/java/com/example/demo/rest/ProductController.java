package com.example.demo.rest;

import com.example.demo.model.Product;
import com.example.demo.model.ProductId;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ProductController implements ProductApi{

    private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping(value = "createProduct")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        System.out.println("Request : " + product);
        return ResponseEntity.ok(service.saveProduct(product));
    }

    @GetMapping(value = "getProducts/type/{type}")
    public ResponseEntity<List<Product>> getProductsByType(@PathVariable String type) {
        return ResponseEntity.ok(service.findProductByType(type));
    }


    @GetMapping(value = "getProduct/id/{id}/version/{version}")
    public ResponseEntity<Optional<Product>> getProductsByIdAndVersion(@PathVariable String id, @PathVariable Long version) {
        return ResponseEntity.ok(service.findByProductId(new ProductId(id, version)));
    }

    @GetMapping(value = "getProducts/id/{id}")
    public ResponseEntity<List<Product>> getProductsById(@PathVariable String id) {
        return ResponseEntity.ok(service.findProductById(id));
    }

    @GetMapping(value = "getProduct/id/{id}")
    public ResponseEntity<Optional<Product>> getProductByIdAndLatestVersion(@PathVariable String id) {
        return ResponseEntity.ok(service.findProductByIdAndLatestVersion(id));
    }


}
