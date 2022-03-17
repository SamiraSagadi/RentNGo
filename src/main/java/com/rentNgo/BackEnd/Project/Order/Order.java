package com.rentNgo.BackEnd.Project.Order;


import java.time.LocalDate;

public class Order {
    private Integer orderId;
    //customer id which is linked to name, email
    private int customerId;
    private LocalDate orderDate;
    private String customerAddress;

    public Order(Integer orderId, int customerId,LocalDate orderDate, String customerAddress) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.customerAddress = customerAddress;
    }

    public Order(){}

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", orderDate=" + orderDate +
                ", customerAddress='" + customerAddress + '\'' +
                '}';
    }
}
