package com.thinkbig.pojo;

import java.util.List;

import lombok.Data;

@Data
public class Product {
    private String productId;
    private String categoryId;
    private String productName;
    private List<String> productColors;
    private String productDescription;
    private List<String> productImages;
    private String productPrice;
    private String productOfferPrice;
    private String productType;
    private int productQuantity;
    private int productRating;
    private List<String> productOcassion;
}
