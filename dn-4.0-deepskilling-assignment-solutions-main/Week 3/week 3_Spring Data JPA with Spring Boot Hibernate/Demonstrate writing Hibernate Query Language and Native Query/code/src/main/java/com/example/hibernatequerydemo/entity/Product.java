package com.example.hibernatequerydemo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private double price;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Order> orders;

    // 👉 Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return name + " (₹" + price + ")";
    }
}
