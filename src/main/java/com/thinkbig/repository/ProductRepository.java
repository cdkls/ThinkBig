package com.thinkbig.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.thinkbig.model.Product;

@Repository
public class ProductRepository {
    
    public static final String PRODUCT_ID = "productId";

    public static final String CATEGORY_ID = "categoryId";
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public Product addProduct(Product product) {
        mongoTemplate.save(product);
        return product;
    }

    public Product findById(String productId) {
        Criteria criteria = Criteria.where(PRODUCT_ID).is(productId);
        Product product = mongoTemplate.findOne(new Query(criteria), Product.class);
        return product;
    }

    public List<Product> findAll() {
        List<Product> products = mongoTemplate.findAll(Product.class);
        return products;
    }

    public Product findByCategoryId(String catergoryId) {
        Criteria criteria = Criteria.where(CATEGORY_ID).is(catergoryId);
        Product product = mongoTemplate.findOne(new Query(criteria), Product.class);
        return product;
    }

}
