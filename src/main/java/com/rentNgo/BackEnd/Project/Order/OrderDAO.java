package com.rentNgo.BackEnd.Project.Order;


public interface OrderDAO {
    int createOrder(Order order);

    int deleteOrder(Integer orderId);

    int updateOrder(Integer orderId, Order order);

}
