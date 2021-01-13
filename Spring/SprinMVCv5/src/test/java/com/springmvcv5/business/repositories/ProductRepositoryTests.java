package com.springmvcv5.business.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.springmvcv5.springapp.business.SpringappBusinessConfig;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.springmvcv5.springapp.business.entities.Product;
import com.springmvcv5.springapp.business.repositories.ProductRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringappBusinessConfig.class})
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testGetProductList() {
        List<Product> products = (List<Product>) productRepository.findAll();
        assertEquals(products.size(), 3, 0);
    }
    
    @Test
    public void testSaveProduct() {
        List<Product> products = (List<Product>) productRepository.findAll();

        Product p = products.get(0);
        Double price = p.getPrice();
        p.setPrice(200.12);
        productRepository.save(p);

        List<Product> updatedProducts = (List<Product>) productRepository.findAll();
        Product p2 = updatedProducts.get(0);
        assertEquals(p2.getPrice(), 200.12, 0);

        p2.setPrice(price);
        productRepository.save(p2);
    }
}
