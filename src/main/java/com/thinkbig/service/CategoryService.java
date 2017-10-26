package com.thinkbig.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkbig.model.Category;
import com.thinkbig.repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    public Category addCategory(Category category) {
        return  categoryRepository.addCategory(category);
    }

    public Category findById(String categoryId) {
        return categoryRepository.findById(categoryId);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

}
