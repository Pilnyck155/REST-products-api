package com.pilnyck.products.repository.jdbc.mapper;

import com.pilnyck.products.entity.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    public Product mapRow(ResultSet resultSet, int numRow) throws SQLException {
        int id = resultSet.getInt("product_id");
        String name = resultSet.getString("name");
        double price = resultSet.getDouble("price");
        Date date = resultSet.getDate("date");
        Product product = Product.builder().
                id(id)
                .name(name)
                .price(price)
                .creationDate(date)
                .build();
        return product;
    }
}
