package com.example.demo.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductId implements Serializable {

    private String id;
    private Long version;

    public ProductId() {
    }

    public ProductId(String id, Long version) {
        this.id = id;
        this.version = version;
    }

    public String getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }
}
