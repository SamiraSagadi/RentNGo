package com.rentNgo.BackEnd.Project.OrderDetail;

public class OrderDetail {
    private Integer orderDetailId;
    private Integer orderId;
    private Integer productId;
    private double totalPrice;
    private int numberOfDaysToRent;

    public OrderDetail(Integer orderDetailId, Integer orderId, Integer productId, double totalPrice, int numberOfDaysToRent) {
        this.orderDetailId = orderDetailId;
        this.orderId = orderId;
        this.productId = productId;
        this.totalPrice = totalPrice;
        this.numberOfDaysToRent = numberOfDaysToRent;
    }

    public OrderDetail() {
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getNumberOfDaysToRent() {
        return numberOfDaysToRent;
    }

    public void setNumberOfDaysToRent(int numberOfDaysToRent) {
        this.numberOfDaysToRent = numberOfDaysToRent;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderDetailId=" + orderDetailId +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", totalPrice=" + totalPrice +
                ", numberOfDaysToRent=" + numberOfDaysToRent +
                '}';
    }
}
