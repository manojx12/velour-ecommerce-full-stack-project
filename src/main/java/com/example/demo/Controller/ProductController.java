// // ProductController.java
// package com.example.demo.controller;

// import com.example.demo.model.Product;
// import com.example.demo.service.ProductService;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;

// @Controller
// @RequestMapping("/products")   // class-level base path
// public class ProductController {

//     private final ProductService productService;

//     public ProductController(ProductService productService) {
//         this.productService = productService;
//     }

//     @GetMapping("")   // matches GET /products
//     public String productsPage(Model model) {
//         model.addAttribute("products", productService.getAllProducts());
//         return "products";
//     }

//     @GetMapping("/product/{id}") // matches GET /products/product/{id}
//     public String productDetail(@PathVariable Long id, Model model) {
//         Product product = productService.getProductById(id);
//         if (product == null) return "redirect:/products";
//         model.addAttribute("product", product);
//         return "product";
//     }
// }
