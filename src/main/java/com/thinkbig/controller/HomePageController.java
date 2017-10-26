package com.thinkbig.controller;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thinkbig.pojo.Category;
import com.thinkbig.pojo.Product;

@RestController
public class HomePageController {
    
    @RequestMapping(value ="/welcome", method = RequestMethod.GET)
    public ResponseEntity<List<ThinkBig>> welcomeMessage(){
        ThinkBig thinkBig=new ThinkBig();
        thinkBig.setName("Welcome To ThinkBig");
        List<ThinkBig> hellos=new ArrayList<>();
        hellos.add(thinkBig);
        return new ResponseEntity<List<ThinkBig>>(hellos, HttpStatus.OK);
    }
    
    @RequestMapping(value ="/categories", method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> categories=Lists.newArrayList();
        Category dresses = Category.builder().categoryId("1").categoryName("Dresses").categoryDescripton("Dresses").build();
        Category sweaters = Category.builder().categoryId("2").categoryName("Sweaters").categoryDescripton("Sweaters").build();
        Category shorts = Category.builder().categoryId("3").categoryName("Shorts & Skirts").categoryDescripton("Shorts & Skirts").build();
        Category jeans = Category.builder().categoryId("4").categoryName("Jeans").categoryDescripton("Jeans").build();
        Category shirts = Category.builder().categoryId("5").categoryName("Shirts & Tops").categoryDescripton("Shirts & Tops").build();
        categories.add(dresses);categories.add(sweaters);categories.add(shorts);categories.add(jeans);categories.add(shirts);
        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }
    
    @RequestMapping(value ="/products", method = RequestMethod.GET,produces="application/json")
    public ResponseEntity<List<Category>> getProducts(){
        List<Category> products=Lists.newArrayList();
        
        Product dressesproduct = Product.builder().productId("1").categoryId("1").productName("Dress").productColors(Lists.newArrayList("RED"))
        .productDescription("Wonderful Dresses").productImages(Lists.newArrayList("images/s1.jpg","images/s2.jpg","images/s3.jpg","images/s4.jpg","images/s5.jpg","images/s6.jpg","images/s7.jpg","images/s8.jpg")).productPrice("$99.00").productOfferPrice("$55.00")
        .productType("Hot").productQuantity(10).productRating(5).productOcassion(Lists.newArrayList("Festival","Party","Nightware")).build();
        
        Category dresses = Category.builder().categoryId("1").categoryName("Dresses").categoryDescripton("Dresses").categoryProducts(Lists.newArrayList(dressesproduct)).build();
        
        Category sweaters = Category.builder().categoryId("2").categoryName("Sweaters").categoryDescripton("Sweaters").categoryProducts(Lists.newArrayList(dressesproduct)).build();
        
        Category shorts = Category.builder().categoryId("3").categoryName("Shorts & Skirts").categoryDescripton("Shorts & Skirts").categoryProducts(Lists.newArrayList(dressesproduct)).build();
        
        Category jeans = Category.builder().categoryId("4").categoryName("Jeans").categoryDescripton("Jeans").categoryProducts(Lists.newArrayList(dressesproduct)).build();
        
        Category shirts = Category.builder().categoryId("5").categoryName("Shirts & Tops").categoryDescripton("Shirts & Tops").categoryProducts(Lists.newArrayList(dressesproduct)).build();
       
        products.add(dresses);products.add(sweaters);products.add(shorts);products.add(jeans);products.add(shirts);
        return new ResponseEntity<List<Category>>(products, HttpStatus.OK);
    }
    
   

}
