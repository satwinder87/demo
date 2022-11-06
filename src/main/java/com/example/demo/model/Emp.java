package com.example.demo.model;

public class Emp {
    private String name;
    private String email;


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    private Emp() {
    }

    public static Emp builder(){
        return new Emp();
    }

    public Emp withName(String name) {
        this.name = name;
        return this;
    }

    public Emp withEmail(String email) {
        this.email = email;
        return this;
    }

    public Emp build() {
        return this;
    }

}
