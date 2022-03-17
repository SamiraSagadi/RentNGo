package com.rentNgo.BackEnd.Project.Customers;

import org.springframework.jdbc.core.RowMapper;
import java.sql.*;

public class CustomerMapper implements RowMapper<Customer> {
    public Customer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setCustomerId(resultSet.getInt("customer_id"));
        customer.setFirstName(resultSet.getString("first_name"));
        customer.setLastName(resultSet.getString("last_name"));
        customer.setEmail(resultSet.getString("email"));
        customer.setPassword(resultSet.getString("password"));
        return customer;

    }
}
