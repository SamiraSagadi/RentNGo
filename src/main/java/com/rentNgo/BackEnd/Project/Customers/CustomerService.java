package com.rentNgo.BackEnd.Project.Customers;

import com.fasterxml.jackson.annotation.JacksonInject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerDAO customerDAO;


    @Autowired
    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    //Selecting all customers
    public List<Customer> getFullListCustomer() {
        List<Customer> customers = customerDAO.selectAllCustomers();
        if (customerDAO.selectAllCustomers() == null) {
            throw new IllegalStateException("No Customers were found");
        }
        return customers;
    }

    private void checkCustomerInputIsNotNull(Customer customer) {
        if (customer.getFirstName() == null) {
            throw new IllegalStateException("First Name cannot be null");
        }
        if (customer.getLastName() == null) {
            throw new IllegalStateException("Last Name cannot be null");
        }
        if (customer.getEmail() == null) {
            throw new IllegalStateException("Email cannot be null");
        }
    }

    public Customer selectCustomerByEmail(String email) {
        if(email == null) {
            System.out.println("Email cannot be empty, please enter an email.");
        }
        return customerDAO.selectCustomerByEmail(email);
    }

    public int addNewCustomer(Customer customer) {
        checkCustomerInputIsNotNull(customer);
        int rowsAffected = customerDAO.addNewCustomer(customer);
        if (rowsAffected <= 0) {
            System.out.println("cannot add person");
        }
        return rowsAffected;
    }

    public int deleteCustomerById(Integer customerId) {
        int rowsAffected = customerDAO.deleteCustomerById(customerId);
        if (rowsAffected <= 0) {
            System.out.println("cannot delete person");
        }
        return rowsAffected;
    }

    public void updateCustomers(Integer customerId, Customer updateCustomer) {
        int result = customerDAO.updateCustomers(customerId, updateCustomer);
        if (result != 1) {
            throw new IllegalStateException("Couldn't update customer!");
        }
    }


}
