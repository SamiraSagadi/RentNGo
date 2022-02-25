package com.rentNgo.BackEnd.Project.Customers;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class  CustomerJDBCTemplate implements CustomerDAO {

    private JdbcTemplate jdbcTemplate;

    public CustomerJDBCTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Customer selectCustomerByEmail(String email) {
        String sql = """
                SELECT customer_id, first_name, last_name, email FROM customers WHERE customers.email = ?;
                """;
        return jdbcTemplate.queryForObject(sql, new CustomerMapper(), email);
    }

    @Override
    public List<Customer> selectAllCustomers() {
        String sql = """
                SELECT customer_id, first_name, last_name, email FROM customers
                """;
        List<Customer> customers = jdbcTemplate.query(sql, new CustomerMapper());
        return customers;
    }


    @Override
    public int addNewCustomer(Customer customer) {
        String sql = """
                INSERT INTO customers (first_name, last_name, email)
                VALUES (?, ?, ?)
                """;
        int rowsAffected = jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(), customer.getEmail());
        return rowsAffected;
    }


    @Override
    public int deleteCustomerById(Integer customerId) {
        String sql = "DELETE FROM customers WHERE customer_id=?";
        int rowsAffected = jdbcTemplate.update(sql, customerId);
        return rowsAffected;
    }

    @Override
    public int updateCustomers(Integer customerId, Customer updateCustomer) {
        String sql = """ 
                UPDATE customers 
                SET (first_name, last_name, email) = (?, ?, ?)
                WHERE customer_id = ?              
                """;
        return jdbcTemplate.update(sql, updateCustomer.getFirstName(), updateCustomer.getLastName(), updateCustomer.getEmail(), customerId);
    }
}

