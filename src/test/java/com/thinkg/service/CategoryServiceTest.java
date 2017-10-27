package com.thinkg.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.thinkbig.model.Category;
import com.thinkbig.repository.CategoryRepository;
import com.thinkbig.service.CategoryService;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {
    
    @InjectMocks
    private CategoryService categoryService;
    
    @Mock
    private CategoryRepository categoryRepository;
    
    private Category category1;
    
    private Category category2;
    
    @Before
    public void init(){
        category1 = Category.builder()._id("1").categoryId("1").categoryId("Mens").categoryDescripton("Mens").build();
        category2 = Category.builder()._id("2").categoryId("2").categoryId("Womens").categoryDescripton("Womens").build();
    }

    @Test
    public void shouldAddCategory(){
        when(categoryRepository.addCategory(any())).thenReturn(category1);
        Category category = categoryService.addCategory(category1);
        assertThat(category, is(category1));
    }
    
    @Test
    public void shouldFindCategoryById(){
        when(categoryRepository.findById(anyString())).thenReturn(category1);
        Category category = categoryService.findById("1");
        assertThat(category, is(category1));
    }
    
    @Test
    public void shouldFindAll(){
        List<Category> categoryList = Lists.newArrayList(category1,category2);
        when(categoryRepository.findAll()).thenReturn(categoryList);
        List<Category> categories = categoryService.findAll();
        assertThat(categories.size(), is(2));
    }
}
