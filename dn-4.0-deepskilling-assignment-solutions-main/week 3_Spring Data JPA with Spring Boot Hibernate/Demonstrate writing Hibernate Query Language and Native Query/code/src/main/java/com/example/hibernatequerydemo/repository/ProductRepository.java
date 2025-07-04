package com.example.hibernatequerydemo.repository;

import com.example.hibernatequerydemo.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    // HQL/JPQL
    @Query("FROM Product p WHERE p.price > ?1")
    List<Product> findExpensiveProducts(double price);

    // Fetch keyword (JPQL)
    @Query("SELECT p FROM Product p JOIN FETCH p.orders")
    List<Product> findAllWithOrders();

    // Aggregate Function
    @Query("SELECT AVG(p.price) FROM Product p")
    Double findAveragePrice();

    // Native SQL Query
    @Query(value = "SELECT * FROM product WHERE name LIKE %?1%", nativeQuery = true)
    List<Product> searchByNameNative(String keyword);
}
