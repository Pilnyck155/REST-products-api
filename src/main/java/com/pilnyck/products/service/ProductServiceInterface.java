package com.pilnyck.products.service;

import com.pilnyck.products.entity.Product;

import java.util.List;

public interface ProductServiceInterface {
    List<Product> findAll();
    void add(Product product);
    Product findById(int id);
    Product edit(int id, Product product);
    void delete(int id);
}
