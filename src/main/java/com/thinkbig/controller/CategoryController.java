package com.thinkbig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thinkbig.model.Category;
import com.thinkbig.service.CategoryService;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("categories")
    @ResponseBody
    public String home() {
        return "Welcome ThinkBig categories!";
    }

    @RequestMapping(value = "/categories/add", method = RequestMethod.POST)
    public @ResponseBody Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @RequestMapping("/categories/findById/{categoryId}")
    public @ResponseBody Category findPersonById(@PathVariable("categoryId") String categoryId) {
        return categoryService.findById(categoryId);
    }

    @RequestMapping("/categories/all")
    public @ResponseBody List<Category> findAll() {
        return categoryService.findAll();
    }

}
