package com.example.orders;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Arrays;

@RestController
@CrossOrigin(origins = "https://orders-frontend-dev-01.gentleglacier-13b71ce3.eastus.azurecontainerapps.io")
public class OrderController {

    @GetMapping("/orders")
    public List<Order> getOrders() {
        return Arrays.asList(
            new Order(1, "Laptop", 1200),
            new Order(2, "Monitor", 300),
            new Order(3, "Mouse", 25),
            new Order(4, "Keyboard", 45)
        );
    }
}