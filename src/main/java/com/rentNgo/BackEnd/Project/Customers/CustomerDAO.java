package com.rentNgo.BackEnd.Project.Customers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface CustomerDAO {
    int addNewCustomer(Customer customer);

    int deleteCustomerById(Integer customerId);

    int updateCustomers(Integer customerId, Customer updateCustomer);

    Customer selectCustomerByEmail(String email, String password);

    List<Customer> selectAllCustomers();

//    int createOrderID(int customerId, LocalDate localDate, LocalTime localTime);

}
