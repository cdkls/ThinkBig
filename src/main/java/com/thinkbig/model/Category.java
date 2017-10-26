package com.thinkbig.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "Category")
public class Category {
    private String _id;
    private String categoryId;
    private String categoryName;
    private String categoryDescripton;
}
