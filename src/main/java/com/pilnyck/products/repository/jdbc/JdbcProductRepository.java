package com.pilnyck.products.repository.jdbc;

import com.pilnyck.products.entity.Product;
import com.pilnyck.products.repository.ProductsRepository;
import com.pilnyck.products.repository.jdbc.mapper.ProductRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class JdbcProductRepository implements ProductsRepository {

    private static final ProductRowMapper PRODUCT_ROW_MAPPER = new ProductRowMapper();
    private static final String FIND_ALL_PRODUCTS = "SELECT product_id, name, price, date FROM Products ORDER BY product_id;";
    public static final String ADD_PRODUCT = "INSERT INTO Products (name, price, date) VALUES (:name, :price, :date);";
    private static final String SELECT_PRODUCT_BY_ID = "SELECT product_id, name, price, date FROM Products WHERE product_id = :id;";
    public static final String UPDATE_PRODUCT = """
            UPDATE Products SET name = :name, price = :price, date = :date WHERE product_id = :id;""";
    public static final String DELETE_PRODUCT = """
            DELETE FROM Products
            WHERE product_id = :id;""";

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query(FIND_ALL_PRODUCTS,PRODUCT_ROW_MAPPER);
    }

    @Override
    public void add(Product product) {
        //jdbcTemplate.update(ADD_PRODUCT, product.getName(), product.getPrice(), product.getCreationDate());
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", product.getName());
        parameters.put("price", product.getPrice());
        parameters.put("date", product.getCreationDate());
        namedParameterJdbcTemplate.update(ADD_PRODUCT, parameters);
    }

    @Override
    public Product findById(int id) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);
        return namedParameterJdbcTemplate.query(SELECT_PRODUCT_BY_ID, parameters, PRODUCT_ROW_MAPPER).get(0);
    }

    @Override
    public void edit(int id, Product product) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);
        parameters.put("name", product.getName());
        parameters.put("price", product.getPrice());
        parameters.put("date", product.getCreationDate());
        namedParameterJdbcTemplate.update(UPDATE_PRODUCT, parameters);
    }

    @Override
    public void delete(int id) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);
        namedParameterJdbcTemplate.update(DELETE_PRODUCT, parameters);
    }
}
