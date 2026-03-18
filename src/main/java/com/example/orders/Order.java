package com.example.orders;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String item;
    private int price;

    public Order() {} // constructor vacío obligatorio para JPA

    public Order(Integer id, String item, int price) {
        this.id = id;
        this.item = item;
        this.price = price;
    }

    // Getters
    public Integer getId() { return id; }
    public String getItem() { return item; }
    public int getPrice() { return price; }

    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setItem(String item) { this.item = item; }
    public void setPrice(int price) { this.price = price; }
}