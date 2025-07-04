package com.example.hibernatequerydemo.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_order")  // Renamed to avoid conflict with SQL keyword 'order'
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    // 👉 Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order ID: " + id + ", Qty: " + quantity +
                ", Product: [" + (product != null ? product.getName() : "null") + "]";
    }
}
