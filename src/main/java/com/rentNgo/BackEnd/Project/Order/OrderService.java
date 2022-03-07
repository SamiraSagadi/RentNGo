package com.rentNgo.BackEnd.Project.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderDAO orderDAO;

    @Autowired
    public void OrderService(OrderDAO orderDAO){
        this.orderDAO = orderDAO;
    }

    public int createOrder(Order order) {
        int rowsAffected = orderDAO.createOrder(order);
        if (rowsAffected != 1) {
            System.out.println("cannot create a new order for customer");
        }
        return rowsAffected;
    }

    public int deleteOrder(Integer orderId) {
        int rowsAffected = orderDAO.deleteOrder(orderId);
        if (rowsAffected <= 0) {
            System.out.println("cannot delete this order");
        }
        return rowsAffected;
    }

    public void updateOrder(Integer orderId, Order order) {
        int result = orderDAO.updateOrder(orderId, order);
        if (result != 1) {
            throw new IllegalStateException("Couldn't update this order");
        }
    }
}
