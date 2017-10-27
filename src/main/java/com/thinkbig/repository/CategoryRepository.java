package com.thinkbig.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.thinkbig.model.Category;

@Repository
public class CategoryRepository {

    public static final String CATEGORY_ID = "categoryId";
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public Category addCategory(Category category) {
        mongoTemplate.save(category);
        return category;
    }

    public Category findById(String categoryId) {
        Criteria criteria = Criteria.where(CATEGORY_ID).is(categoryId);
        Category category = mongoTemplate.findOne(new Query(criteria), Category.class);
        return category;
    }

    public List<Category> findAll() {
        List<Category> categories = mongoTemplate.findAll(Category.class);
        return categories;
    }

    public void dropCollection() {
        mongoTemplate.dropCollection(Category.class);
    }

}
