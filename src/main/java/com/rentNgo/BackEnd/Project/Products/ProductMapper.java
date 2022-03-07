package com.rentNgo.BackEnd.Project.Products;

import org.springframework.jdbc.core.RowMapper;
import java.sql.*;

public class ProductMapper implements RowMapper<Product> {
    public Product mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Product product = new Product();
        product.setProductId(resultSet.getInt("product_id"));
        product.setName(resultSet.getString("name"));
        product.setCategory(resultSet.getString("category"));
        product.setDailyPrice(resultSet.getDouble("daily_price"));
        return product;
    }
}
