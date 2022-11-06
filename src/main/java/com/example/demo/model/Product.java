package com.example.demo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Product {
    @EmbeddedId
    private ProductId productId;
    private String name;
    private String type;

    public Product() {
    }

    public Product(ProductId productId, String name, String type) {
        this.productId = productId;
        this.name = name;
        this.type = type;
    }

    public ProductId getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
