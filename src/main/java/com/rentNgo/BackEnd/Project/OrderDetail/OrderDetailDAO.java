package com.rentNgo.BackEnd.Project.OrderDetail;


public interface OrderDetailDAO {
    int createOrderBasket(OrderDetail orderDetail);

    int deleteOrderBasket(Integer orderDetailId);

    int updateOrderBasket(Integer orderDetailId, OrderDetail orderDetail);

}
