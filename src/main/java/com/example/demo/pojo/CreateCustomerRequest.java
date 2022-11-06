package com.example.demo.pojo;

public class CreateCustomerRequest {
    private final String name;
    private final String email;
    private final String city;

    public CreateCustomerRequest(String name, String email, String city) {
        this.name = name;
        this.email = email;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }
}
