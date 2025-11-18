// package com.example.demo.service;

// import com.example.demo.model.Product;
// import org.springframework.stereotype.Service;

// import java.util.ArrayList;
// import java.util.List;

// @Service
// public class ProductService {

//     private final List<Product> productList = new ArrayList<>();

//     public ProductService() {
//         productList.add(new Product(1L, "Product 1", "Description of Product 1", 499.0, "/img/product1.jpg"));
//         productList.add(new Product(2L, "Product 2", "Description of Product 2", 799.0, "/img/product2.jpg"));
//         productList.add(new Product(3L, "Product 3", "Description of Product 3", 999.0, "/img/product3.jpg"));
//         productList.add(new Product(4L, "Product 4", "Description of Product 4", 1299.0, "/img/product4.jpg"));
//     }

//     public List<Product> getAllProducts() {
//         return new ArrayList<>(productList);
//     }

//     public Product getProductById(Long id) {
//         return productList.stream()
//                 .filter(p -> p.getId().equals(id))
//                 .findFirst()
//                 .orElse(null);
//     }
// }
