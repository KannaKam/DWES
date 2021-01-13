package com.springmvcv5.springapp.business.services;

import java.util.List;

import com.springmvcv5.springapp.business.entities.Product;

public interface ProductManager {

    public void increasePrice(int percentage);
    
    public List<Product> getProducts();

}
