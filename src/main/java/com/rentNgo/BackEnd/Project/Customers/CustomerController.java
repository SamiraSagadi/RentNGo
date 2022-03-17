package com.rentNgo.BackEnd.Project.Customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/get-all-customers")
    public List<Customer> listAllCustomers() {
        return customerService.getFullListCustomer();
    }

    @PostMapping(path = "/add-new-customer")
    void createNewCustomer(@RequestBody Customer customer) {
        System.out.println("POST REQUEST.....");
        customerService.addNewCustomer(customer);
        System.out.println(customer);
    }

    @PutMapping(path = "/edit/{customerId}")
    public void updateCustomer(@PathVariable("customerId") Integer customerId, @RequestBody Customer updateCustomer) {
        System.out.println("UPDATE REQUEST.....");
        customerService.updateCustomers(customerId, updateCustomer);
    }

    @DeleteMapping(path = "/delete/{customerId}")
    void deleteCustomer(@PathVariable("customerId") Integer customerId) {
        System.out.println("DELETE REQUEST FOR CUSTOMER WITH ID: " + customerId);
        customerService.deleteCustomerById(customerId);
    }

}
