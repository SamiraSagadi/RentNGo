package com.rentNgo.BackEnd.Project.Customers;

import org.springframework.context.annotation.Bean;

import java.util.List;

public interface CustomerDAO {
    int addNewCustomer(Customer customer);

    int deleteCustomerById(Integer customerId);

    int updateCustomers(Integer customerId, Customer updateCustomer);

    Customer selectCustomerById(Integer customerId);

    List<Customer> selectAllCustomers();

}
