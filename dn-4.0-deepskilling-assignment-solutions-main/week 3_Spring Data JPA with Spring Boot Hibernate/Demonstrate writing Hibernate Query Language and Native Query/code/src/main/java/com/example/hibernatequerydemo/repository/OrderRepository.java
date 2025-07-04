package com.example.hibernatequerydemo.repository;

import com.example.hibernatequerydemo.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    // HQL
    @Query("SELECT o FROM Order o WHERE o.quantity >= ?1")
    List<Order> findBulkOrders(int minQty);

    // Native Query
    @Query(value = "SELECT * FROM product_order WHERE quantity < ?1", nativeQuery = true)
    List<Order> findSmallOrdersNative(int maxQty);
}
