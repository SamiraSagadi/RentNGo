package com.rentNgo.BackEnd.Project.OrderDetail;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDetailRepository implements OrderDetailDAO {
    private JdbcTemplate jdbcTemplate;

    public OrderDetailRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int createOrderBasket(OrderDetail orderDetail) {
        String createSql = """
                INSERT INTO orderdetail (order_id, product_id, total_price, number_of_days_rent)
                VALUES (?, ?, ?, ?)
                """;
        int rowsAffected = jdbcTemplate.update(createSql, orderDetail.getOrderId(), orderDetail.getProductId(), orderDetail.getTotalPrice(), orderDetail.getNumberOfDaysToRent());
        return rowsAffected;
    }

    @Override
    public int deleteOrderBasket(Integer orderDetailId) {
        String deleteSql = "DELETE FROM orderdetail WHERE order_detail_id=?";
        int rowsAffected = jdbcTemplate.update(deleteSql, orderDetailId);
        return rowsAffected;
    }

    @Override
    public int updateOrderBasket(Integer orderDetailId, OrderDetail orderDetail) {
        String updateSql = """ 
                UPDATE orderdetail 
                SET (order_id, product_id, total_price, number_of_days_rent) = (?, ?, ?, ?)
                WHERE order_detail_id = ?              
                """;
        return jdbcTemplate.update(updateSql, orderDetail.getOrderId(), orderDetail.getProductId(), orderDetail.getTotalPrice(), orderDetail.getNumberOfDaysToRent(), orderDetailId);
    }

}
