package com.example.orders;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrdersBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrdersBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(OrderRepository repository) {
        return args -> {
            if (repository.count() == 0) { // solo si la tabla está vacía
                repository.save(new Order(null, "Laptop", 1200));
                repository.save(new Order(null, "Monitor", 300));
                repository.save(new Order(null, "Mouse", 25));
                repository.save(new Order(null, "Keyboard", 45));
            }
        };
    }
}