package com.thinkbig.repository;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thinkbig.model.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class ProductRepositoryTest{

    @Autowired
    ProductRepository productRepository;

    private Product product1;
    
    private Product product2;
    
    @Before
    public void setUp() throws Exception {
        productRepository.dropCollection();
        product1 = Product.builder()._id("1").productId("1").categoryId("Mens").productName("Mens").productColors(Lists.emptyList())
                .productDescription("").productImages(Lists.emptyList())
                .productPrice("10").productOfferPrice("8").productType("GOLD").productQuantity(4).productRating(5).productOcassion(Lists.emptyList()).build();
        productRepository.addProduct(product1);
        
        product2 = Product.builder()._id("2").productId("2").categoryId("Mens").productName("Mens").productColors(Lists.emptyList())
                .productDescription("").productImages(Lists.emptyList())
                .productPrice("10").productOfferPrice("8").productType("GOLD").productQuantity(4).productRating(5).productOcassion(Lists.emptyList()).build();
        productRepository.addProduct(product2);
    }

    @Test
    public void shouldRetrieveProductById() {
        Product product = productRepository.findById("1");
        assertThat(product, is(product1));
    }
    
    @Test
    public void shouldRetrieveProductByCategoryId() {
        Product product = productRepository.findByCategoryId("2");
        assertThat(product, is(product2));
    }
    
    
    @Test
    public void shouldRetrieveGapBrandForGivenBrandId() {
        List<Product> products = productRepository.findAll();
        assertThat(products.size(), is(2));
    }
}
