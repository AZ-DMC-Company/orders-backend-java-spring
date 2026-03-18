package com.example.orders;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "https://orders-frontend-dev-01.gentleglacier-13b71ce3.eastus.azurecontainerapps.io")
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Order> getOrders() {
        return repository.findAll();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        order.setId(null); // MySQL generará automáticamente el ID
        return repository.save(order);
    }
}