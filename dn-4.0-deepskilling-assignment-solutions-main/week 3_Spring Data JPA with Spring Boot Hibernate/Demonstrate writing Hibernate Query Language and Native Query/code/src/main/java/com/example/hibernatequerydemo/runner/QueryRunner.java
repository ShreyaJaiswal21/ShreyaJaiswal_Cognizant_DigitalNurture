package com.example.hibernatequerydemo.runner;

import com.example.hibernatequerydemo.entity.Order;
import com.example.hibernatequerydemo.entity.Product;
import com.example.hibernatequerydemo.repository.OrderRepository;
import com.example.hibernatequerydemo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class QueryRunner implements CommandLineRunner {

    private final ProductRepository productRepo;
    private final OrderRepository orderRepo;

    public QueryRunner(ProductRepository productRepo, OrderRepository orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    @Override
    public void run(String... args) {
        Product p1 = new Product(); p1.setName("Mouse"); p1.setPrice(500);
        Product p2 = new Product(); p2.setName("Keyboard"); p2.setPrice(1200);
        Product p3 = new Product(); p3.setName("Monitor"); p3.setPrice(7500);

        productRepo.saveAll(Arrays.asList(p1, p2, p3));

        Order o1 = new Order(); o1.setProduct(p1); o1.setQuantity(10);
        Order o2 = new Order(); o2.setProduct(p2); o2.setQuantity(5);
        Order o3 = new Order(); o3.setProduct(p3); o3.setQuantity(2);
        orderRepo.saveAll(Arrays.asList(o1, o2, o3));

        System.out.println("\n>> Expensive Products > 1000: " + productRepo.findExpensiveProducts(1000));
        System.out.println("\n>> Products with Orders: " + productRepo.findAllWithOrders());
        System.out.println("\n>> Avg Product Price: " + productRepo.findAveragePrice());
        System.out.println("\n>> Native search 'key': " + productRepo.searchByNameNative("key"));
        System.out.println("\n>> Bulk Orders >= 5: " + orderRepo.findBulkOrders(5));
        System.out.println("\n>> Small Orders < 5 (Native): " + orderRepo.findSmallOrdersNative(5));
    }
}
