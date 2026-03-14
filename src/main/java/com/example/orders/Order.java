package com.example.orders;

public class Order {
    private int id;
    private String item;
    private int price;

    public Order(int id, String item, int price) {
        this.id = id;
        this.item = item;
        this.price = price;
    }

    // Getters
    public int getId() { return id; }
    public String getItem() { return item; }
    public int getPrice() { return price; }
}