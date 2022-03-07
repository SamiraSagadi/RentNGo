package com.rentNgo.BackEnd.Project.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "products")
@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/get-all-products")
    public void fullProductList() {
        System.out.println(productService.getProductList());
    }

    @PostMapping(path = "/create-new-product")
    void createNewProduct(@RequestBody Product product) {
        System.out.println("POST REQUEST.....");
        productService.addProduct(product);
        System.out.println(product);
    }

    @PutMapping(path = "edit/{productId}")
    public void updateProduct(@PathVariable("productId") Integer productId, @RequestBody Product updateProduct) {
        System.out.println("UPDATE REQUEST.....");
        productService.updateProduct(productId, updateProduct);
    }

    @DeleteMapping(path = "/delete/{productId}")
    void deleteProduct(@PathVariable("productId") Integer productId) {
        System.out.println("DELETE REQUEST FOR PRODUCT WITH ID: " + productId);
        productService.deleteProductById(productId);
    }
}
