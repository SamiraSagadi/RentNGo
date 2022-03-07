package com.rentNgo.BackEnd.Project.Products;

public class Product {
    private Integer productId;
    private String name;
    private String category;
    private double dailyPrice;
    private String availability;

    public Product(Integer productId, String name, String category, double dailyPrice, String availability) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.dailyPrice = dailyPrice;
        this.availability =availability;
    }

    public Product() {

    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(double dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", dailyPrice=" + dailyPrice +
                ", availability='" + availability + '\'' +
                '}';
    }
}
