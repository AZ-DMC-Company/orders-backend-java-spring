package com.example.orders;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Arrays;

@RestController
public class OrderController {
    @GetMapping("/orders")
    public List<String> getOrders() {
        return Arrays.asList("Orden 1", "Orden 2", "Orden 3", "Orden 4");
    }
}