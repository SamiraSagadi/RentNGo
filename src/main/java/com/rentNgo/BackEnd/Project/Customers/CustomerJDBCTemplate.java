package com.rentNgo.BackEnd.Project.Customers;

import com.rentNgo.BackEnd.Project.Products.Product;
import com.rentNgo.BackEnd.Project.Products.ProductJDBCTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public class  CustomerJDBCTemplate implements CustomerDAO {
    private JdbcTemplate jdbcTemplate;

    public CustomerJDBCTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Customer selectCustomerByEmail(String email) {
        String selectCustomerSql = """
                SELECT customer_id, first_name, last_name, email FROM customers WHERE customers.email = ? AND customers.password= ?;
                """;
        return jdbcTemplate.queryForObject(selectCustomerSql, new CustomerMapper(), email);
    }

    @Override
    public List<Customer> selectAllCustomers() {
        String selectAllSql = """
                SELECT customer_id, first_name, last_name, email FROM customers
                """;
        List<Customer> customers = jdbcTemplate.query(selectAllSql, new CustomerMapper());
        return customers;
    }


    @Override
    public int addNewCustomer(Customer customer) {
        String addSql = """
                INSERT INTO customers (first_name, last_name, email, password)
                VALUES (?, ?, ?, ?)
                """;
        int rowsAffected = jdbcTemplate.update(addSql, customer.getFirstName(), customer.getLastName(), customer.getEmail(), customer.getPassword());
        return rowsAffected;
    }


    @Override
    public int deleteCustomerById(Integer customerId) {
        String deleteSql = "DELETE FROM customers WHERE customer_id=?";
        int rowsAffected = jdbcTemplate.update(deleteSql, customerId);
        return rowsAffected;
    }

    @Override
    public int updateCustomers(Integer customerId, Customer updateCustomer) {
        String updateSql = """ 
                UPDATE customers 
                SET (first_name, last_name, email, password) = (?, ?, ?, ?)
                WHERE customer_id = ?              
                """;
        return jdbcTemplate.update(updateSql, updateCustomer.getFirstName(), updateCustomer.getLastName(), updateCustomer.getEmail(), updateCustomer.getPassword(), customerId);
    }



}

