package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PingControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void testPing() throws Exception {
        String url = "http://localhost:" + port + "/";
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", base64Encoder("user", "password"));

        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Ping Sent...", response.getBody());
    }

    @Test
    public void testHealthEndpoint() throws Exception {
        String url = "http://localhost:" + port + "/actuator/health";
        ResponseEntity<String> response = this.restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    private String base64Encoder(String userName, String password) {
        String valueToEncode = userName + ":" + password;
        return "Basic " + Base64.getEncoder().encodeToString(valueToEncode.getBytes());
    }
}
