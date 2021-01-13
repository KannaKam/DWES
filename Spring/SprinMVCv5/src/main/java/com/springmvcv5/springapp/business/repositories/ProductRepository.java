package com.springmvcv5.springapp.business.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springmvcv5.springapp.business.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
