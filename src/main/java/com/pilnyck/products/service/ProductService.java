package com.pilnyck.products.service;

import com.pilnyck.products.entity.Product;
import com.pilnyck.products.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class ProductService implements ProductServiceInterface {
    private final ProductsRepository productsRepository;

    @Override
    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    @Override
    public void add(Product product) {
        productsRepository.add(product);
    }

    @Override
    public Product findById(int id) {
        Product productById = productsRepository.findById(id);
        return productById;
    }

    @Override
    public Product edit(int id, Product product) {
        Product productFromDB = productsRepository.findById(id);
        if (Objects.nonNull(product.getName()) && !"".equalsIgnoreCase(product.getName())){
            productFromDB.setName(product.getName());
        }
        if (Objects.nonNull(product.getPrice()) && !"".equals(product.getPrice())){
            productFromDB.setPrice(product.getPrice());
        }
        if (Objects.nonNull(product.getCreationDate()) && !"".equalsIgnoreCase(product.getCreationDate().toString())){
            productFromDB.setCreationDate(product.getCreationDate());
        }

        productsRepository.edit(id, product);
        return productsRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        productsRepository.delete(id);
    }
}
