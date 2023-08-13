package com.demo.prometheus.controller;


import com.demo.prometheus.entity.Product;
import com.demo.prometheus.service.ProductService;
import io.micrometer.observation.annotation.Observed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@Observed
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        log.info("Create product, product = {}.", product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> findAllProducts() {
        log.info("Fetching products");
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable int id) throws Exception {
        log.info("Fetching product => {}", id);
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProductById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
