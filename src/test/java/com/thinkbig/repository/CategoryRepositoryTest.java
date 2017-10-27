package com.thinkbig.repository;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thinkbig.model.Category;


@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class CategoryRepositoryTest{

    @Autowired
    CategoryRepository categoryRepository;

    private Category category1;
    
    private Category category2;
    
    @Before
    public void setUp() throws Exception {
        categoryRepository.dropCollection();
        category1 = Category.builder()._id("1").categoryId("1").categoryName("Mens").categoryDescripton("Mens").build();
        category2 = Category.builder()._id("2").categoryId("2").categoryName("Womens").categoryDescripton("Womens").build();
        categoryRepository.addCategory(category1);
        categoryRepository.addCategory(category2);
    }

    @Test
    public void shouldRetrieveCategoryById() {
        Category category = categoryRepository.findById("1");
        assertThat(category, is(category1));
    }
    
    @Test
    public void shouldRetrieveAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        assertThat(categories.size(), is(2));
    }
}
