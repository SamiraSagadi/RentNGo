package com.rentNgo.BackEnd.Project.Products;

import java.util.List;

public interface ProductDAO {
    int addProduct(Product product);

    int deleteProductById(Integer productId);

    int updateProduct(Integer productId, Product updateProduct);

    Product selectProductById(Integer productId);

    Product selectProductsByName(String name);

    List<Product> selectAllProducts();
}
