package com.thinkbig.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@Data
@AllArgsConstructor
@Document(collection = "Product")
public class Product {
    private String _id;
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
