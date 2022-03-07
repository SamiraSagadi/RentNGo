package com.rentNgo.BackEnd.Project.Order;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.time.LocalDate;

@Repository
public class OrderRepository implements OrderDAO{
    private final JdbcTemplate jdbcTemplate;

    public OrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int createOrderID(int customerId, LocalDate orderDate, String customerAddress){
        String customerIdInOrderDBSql = "SELECT customer_id FROM orders WHERE customer_id = (SELECT customer_id FROM customers WHERE customers.email = ?)";
        try {
            int customerIdInOrderDB = jdbcTemplate.queryForObject(customerIdInOrderDBSql, ResultSet::getInt);
        } catch (Exception e){
            System.out.println("No items for this customer!");
        }

        String createOrderRecord = "INSERT INTO orders(customer_id, order_date, customer_address) VALUES (?, ?, ?)";
        System.out.println(jdbcTemplate.update(createOrderRecord, customerId, orderDate, customerAddress));

        String orderIDSql = "SELECT order_id FROM orderinformation WHERE customer_id = ?, order_date = ? AND customer_address = ?";
        int orderID = jdbcTemplate.queryForObject(orderIDSql, ResultSet::getInt);
        return orderID;
    }

    @Override
    public int createOrder(Order order) {
        String createSql = """
                INSERT INTO orders (customer_id, order_date,customer_address)
                VALUES (?, ?, ?)
                """;
        int rowsAffected = jdbcTemplate.update(createSql, order.getCustomerId(), order.getOrderDate(), order.getCustomerAddress());
        return rowsAffected;
    }

    @Override
    public int deleteOrder(Integer orderId) {
        String deleteSql = "DELETE FROM orders WHERE order_id=?";
        int rowsAffected = jdbcTemplate.update(deleteSql, orderId);
        return rowsAffected;
    }

    @Override
    public int updateOrder(Integer orderId, Order order) {
        String updateSql = """ 
                UPDATE orders 
                SET (customer_id, order_date, customer_address) = (?, ?, ?)
                WHERE order_id = ?              
                """;
        return jdbcTemplate.update(updateSql, order.getCustomerId(), order.getOrderDate(), order.getCustomerAddress(), orderId);
    }
}
