package com.thinkbig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkbig.model.Product;
import com.thinkbig.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public Product addProduct(Product product) {
        return  productRepository.addProduct(product);
    }

    public Product findById(String productId) {
        return productRepository.findById(productId);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

}
