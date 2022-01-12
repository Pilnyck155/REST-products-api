package com.pilnyck.products.web;

import com.pilnyck.products.entity.Product;
import com.pilnyck.products.service.ProductService;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductService productService;
    Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping
    public List<Product> findAll() {
        List<Product> products = productService.findAll();
        logger.info("products {}", products);
        return products;
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productService.add(product);
        logger.info("add product {}", product);
    }

    //TODO: Write method findById
    @GetMapping("/{id}")
    public Product findById(@PathVariable int id){
        Product productById = productService.findById(id);
        logger.info("product by id {}", productById);
        return productById;
    }

    //TODO: Write method edit
    @PutMapping("/{id}")
    public Product editProduct(@RequestBody Product product, @PathVariable("id") int id){
        logger.info("product to edit {}", product);
        return productService.edit(id, product);
    }

    //TODO: Write method delete
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        productService.delete(id);
        logger.info("id product to delete {}", id);
    }
}
