package com.demo.prometheus.service.impl;


import com.demo.prometheus.entity.Product;
import com.demo.prometheus.repository.ProductRepository;
import com.demo.prometheus.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) throws Exception {
        Optional<Product> productOptional = productRepository.findById(id);
        if (!productOptional.isPresent()) {
            throw new Exception("Product not found");
        }
        return productOptional.get();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }
}
