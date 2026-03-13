package com.example.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@SpringBootApplication
@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "https://ca-ricvera-dev-frontend.greenbush-9511773a.westus2.azurecontainerapps.io")
public class OrdersApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdersApplication.class, args);
    }

    @GetMapping
    public List<Map<String, String>> getOrders() {
        List<Map<String, String>> orders = new ArrayList<>();
        orders.add(Map.of("id", "1", "name", "Orden 1"));
        orders.add(Map.of("id", "2", "name", "Orden 2"));
        return orders;
    }
}