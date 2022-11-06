package com.example.demo.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping(value = "/",produces = MediaType.APPLICATION_JSON_VALUE)
    public String ping() {
        return "Ping Sent...";
    }
}
