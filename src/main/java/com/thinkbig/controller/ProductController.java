package com.thinkbig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thinkbig.model.Product;
import com.thinkbig.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("products")
    @ResponseBody
    public String home() {
        return "Welcome ThinkBig Products!";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public @ResponseBody Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @RequestMapping("/products/findById/{productId}")
    public @ResponseBody Product findProductById(@PathVariable("productId") String productId) {
        return productService.findById(productId);
    }
    
    @RequestMapping("/products/findByCategoryId/{catergoryId}")
    public @ResponseBody Product findByCategoryId(@PathVariable("catergoryId") String catergoryId) {
        return productService.findByCategoryId(catergoryId);
    }

    @RequestMapping("/products/all")
    public @ResponseBody List<Product> findAll() {
        return productService.findAll();
    }

}
