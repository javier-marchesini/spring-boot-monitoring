package com.demo.prometheus.service;

import com.demo.prometheus.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product getProductById(Integer id) throws Exception;

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}
