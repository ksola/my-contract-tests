package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Client
{
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/")
    public String sayHelloAgain() {
        // call server
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:8080", HttpMethod.GET,
                new HttpEntity<>("", new HttpHeaders()),
                String.class);
        return exchange.getBody();
    }
}
