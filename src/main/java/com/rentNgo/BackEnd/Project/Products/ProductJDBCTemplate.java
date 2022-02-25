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
                INSERT INTO products (name, category, price)
                VALUES (?, ?, ?)
                """;
        int rowsAffected = jdbcTemplate.update(sql, product.getName(), product.getCategory(), product.getPrice());
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
                SET (name, category, price) = (?, ?, ?)
                WHERE product_id = ?              
                """;
        return jdbcTemplate.update(sql, updateProduct.getName(), updateProduct.getCategory(), updateProduct.getPrice(), productId);
    }

    @Override
    public Product selectProductById(Integer productId) {
        String sql = """
                SELECT product_id, name, category, price FROM products WHERE product.product_id = ?
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
}
