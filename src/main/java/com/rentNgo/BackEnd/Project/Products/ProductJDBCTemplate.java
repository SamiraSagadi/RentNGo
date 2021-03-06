package com.rentNgo.BackEnd.Project.Products;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductJDBCTemplate implements ProductDAO {

    private final JdbcTemplate jdbcTemplate;

    public ProductJDBCTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addProduct(Product product) {
        String sql = """
                INSERT INTO products (name, category, daily_price, availability)
                VALUES (?, ?, ?, ?)
                """;
        int rowsAffected = jdbcTemplate.update(sql, product.getName(), product.getCategory(), product.getDailyPrice(), product.getAvailability());
        return rowsAffected;
    }

    @Override
    public int deleteProductById(Integer productId) {
        String sql = "DELETE FROM products WHERE product_id=?";
        int rowsAffected = jdbcTemplate.update(sql, productId);
        return rowsAffected;
    }

    @Override
    public int updateProduct(Integer productId, Product updateProduct) {
        String sql = """ 
                UPDATE products 
                SET (name, category, daily_price, availability) = (?, ?, ?,?)
                WHERE product_id = ?              
                """;
        return jdbcTemplate.update(sql, updateProduct.getName(), updateProduct.getCategory(), updateProduct.getDailyPrice(), updateProduct.getAvailability(), productId);
    }

    @Override
    public Product selectProductById(Integer productId) {
        String sql = """
                SELECT product_id, name, category, daily_price, availability FROM products WHERE product.product_id = ?
                """;
        return jdbcTemplate.queryForObject(sql, new ProductMapper(), productId);
    }

    @Override
    public List<Product> selectAllProducts() {
        String sql = """
                SELECT * FROM products
                """;
        List<Product> products = jdbcTemplate.query(sql, new ProductMapper());
        return products;
    }

    @Override
    public Product selectProductsByName(String name) {
        String sql = """
                SELECT * FROM products WHERE name = ?
                """;
        return jdbcTemplate.queryForObject(sql, new ProductMapper(), name);
    }
}
