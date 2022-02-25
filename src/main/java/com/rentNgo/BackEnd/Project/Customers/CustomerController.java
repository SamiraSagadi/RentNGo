package com.rentNgo.BackEnd.Project.Customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public void listAllCustomers() {
        System.out.println(customerService.getFullListCustomer());
    }


    @PostMapping
    void createNewCustomer(@RequestBody Customer customer) {
        System.out.println("POST REQUEST.....");
        customerService.addNewCustomer(customer);
        System.out.println(customer);
    }

    @PutMapping(path = "{customerId}")
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
