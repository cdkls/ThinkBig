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

import com.thinkbig.model.Product;
import com.thinkbig.repository.ProductRepository;
import com.thinkbig.service.ProductService;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
    
    @InjectMocks
    private ProductService productService;
    
    @Mock
    private ProductRepository productRepository;
    
    private Product product1;
    
    private Product product2;

    @Before
    public void init(){
        product1 = Product.builder()._id("1").productId("1").categoryId("Mens").productName("Mens").productColors(Lists.emptyList())
                .productDescription("").productImages(Lists.emptyList())
                .productPrice("10").productOfferPrice("8").productType("GOLD").productQuantity(4).productRating(5).productOcassion(Lists.emptyList()).build();
        
        product2 = Product.builder()._id("2").productId("2").categoryId("Mens").productName("Mens").productColors(Lists.emptyList())
                .productDescription("").productImages(Lists.emptyList())
                .productPrice("10").productOfferPrice("8").productType("GOLD").productQuantity(4).productRating(5).productOcassion(Lists.emptyList()).build();
    }
    
    @Test
    public void shouldAddProduct(){
        when(productRepository.addProduct(any())).thenReturn(product1);
        Product product = productService.addProduct(product1);
        assertThat(product, is(product1));
    }
    
    @Test
    public void shouldFindProductById(){
        when(productRepository.findById(anyString())).thenReturn(product1);
        Product product = productService.findById("1");
        assertThat(product, is(product1));
    }
    
    @Test
    public void shouldFindAll(){
        when(productRepository.findByCategoryId(anyString())).thenReturn(product2);
        Product product = productService.findByCategoryId("2");
        assertThat(product, is(product2));
    }
    
    @Test
    public void shouldFindAllProducts(){
        List<Product> productList = Lists.newArrayList(product1,product2);
        when(productRepository.findAll()).thenReturn(productList);
        List<Product> products = productService.findAll();
        assertThat(products.size(), is(2));
    }
}
