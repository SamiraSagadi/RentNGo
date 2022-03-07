package com.rentNgo.BackEnd.Project.OrderDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {
    private OrderDetailDAO orderDetailDAO;

    @Autowired
    public void OrderDetailService(OrderDetailDAO orderDetailDAO){
        this.orderDetailDAO = orderDetailDAO;
    }

    public int createOrderBasket(OrderDetail orderDetail) {
        int rowsAffected = orderDetailDAO.createOrderBasket(orderDetail);
        if (rowsAffected != 1) {
            System.out.println("cannot add products to your basket");
        }
        return rowsAffected;
    }

    public int deleteOrderBasket(Integer orderDetailId) {
        int rowsAffected = orderDetailDAO.deleteOrderBasket(orderDetailId);
        if (rowsAffected <= 0) {
            System.out.println("cannot delete products from the basket.");
        }
        return rowsAffected;
    }

    public void updateOrderBasket(Integer orderDetailId, OrderDetail orderDetail) {
        int result = orderDetailDAO.updateOrderBasket(orderDetailId, orderDetail);
        if (result != 1) {
            throw new IllegalStateException("Couldn't update the order basket!");
        }
    }
}
