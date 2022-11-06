package com.example.demo.model;

public class Order {
    private String userName;
    private String address;

    public Order(String userName, String address) {
        this.userName = userName;
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public String getAddress() {
        return address;
    }
}
