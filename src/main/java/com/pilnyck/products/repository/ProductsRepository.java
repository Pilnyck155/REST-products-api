package com.pilnyck.products.repository;

import com.pilnyck.products.entity.Product;

import java.util.List;

public interface ProductsRepository {
    List<Product> findAll();

    void add(Product product);

    Product findById(int id);

    void edit(int id, Product product);

    void delete(int id);

}
