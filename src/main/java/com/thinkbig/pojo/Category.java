package com.thinkbig.pojo;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Category {
    private String categoryId;
    private String categoryName;
    private String categoryDescripton;
    private List<Product> categoryProducts;
}
