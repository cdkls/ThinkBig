package com.thinkbig.pojo;

import java.util.List;
import lombok.Data;

@Data
public class Category {
    private String categoryId;
    private String categoryName;
    private String categoryDescripton;
    private List<Product> categoryProducts;
}
