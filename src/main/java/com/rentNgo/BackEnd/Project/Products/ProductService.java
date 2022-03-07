package com.rentNgo.BackEnd.Project.Products;

import com.rentNgo.BackEnd.Project.Customers.Customer;
import com.rentNgo.BackEnd.Project.Customers.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductDAO productDAO;

    @Autowired
    public void ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    private void checkProductInputIsNotNull(Product product) {
        if (product.getName() == null) {
            throw new IllegalStateException("First Name cannot be null");
        }
        if (product.getCategory() == null) {
            throw new IllegalStateException("Last Name cannot be null");
        }
        if (product.getDailyPrice() <= 0) {
            throw new IllegalStateException("Price cannot be less than or equal to zero");
        }
        if (product.getAvailability() == null) {
            throw new IllegalStateException("Availability of the product cannot be null");
        }
    }

    public int addProduct(Product product) {
        checkProductInputIsNotNull(product);
        int rowsAffected = productDAO.addProduct(product);
        if (rowsAffected != 1) {
            System.out.println("cannot add product");
        }
        return rowsAffected;
    }

    public void updateProduct(Integer productId, Product updateProduct) {
        int result = productDAO.updateProduct(productId, updateProduct);
        if (result != 1) {
            throw new IllegalStateException("Couldn't update product!");
        }
    }

    public int deleteProductById(Integer productId) {
        int rowsAffected = productDAO.deleteProductById(productId);
        if (rowsAffected <= 0) {
            System.out.println("cannot delete product.");
        }
        return rowsAffected;
    }

    public List<Product> getProductList() {
        List<Product> products = productDAO.selectAllProducts();
        if (productDAO.selectAllProducts() == null) {
            throw new IllegalStateException("No products were found");
        }
        return products;
    }
}
