package com.rentNgo.BackEnd.Project.Customers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {
    private CustomerService underTest;
    private CustomerDAO customerDAO;

    @BeforeEach
    void setUp(){
        customerDAO = Mockito.mock(CustomerDAO.class);
        underTest = new CustomerService(customerDAO);
    }

    @Test
    void shouldThrowAnErrorIfThereIsNoCustomer(){
        //Given
        given(customerDAO.selectAllCustomers()).willReturn(null);
        //When -> there is no customers
        //Then
        assertThatThrownBy(()-> underTest.getFullListCustomer())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("No Customers were found");
    }

    @Test
    void shouldReturnAllCustomersPresent(){
        //Given
        Customer customer1 = new Customer(1, "Joseph", "Millard", "J.Millard@hotmail.com", "abc123");
        Customer customer2 = new Customer(2, "Leo", "West", "LW2@hotmail.co.uk", "password123");
        Customer customer3 = new Customer(3, "Penelope", "King", "King10@gmail.com", "123pAssword");

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);

        given(customerDAO.selectAllCustomers()).willReturn(customerList);
        //When
        List<Customer> listOfActualCustomers = underTest.getFullListCustomer();
        //Then
        assertThat(customerList).isEqualTo(listOfActualCustomers);
        System.out.println(customerList);
        System.out.println(listOfActualCustomers);
    }


    @Test
    void shouldGetCustomerByValidEmail(){
        //Given
        String customerEmail = "lou1@gmail.com";
        Customer expectedCustomer = new Customer(4, "Louisa", "Johnson", "lou1@gmail.com", "abc1@");

        given(customerDAO.selectCustomerByEmail(customerEmail)).willReturn(expectedCustomer);
        //When
        Customer actualCustomer = underTest.selectCustomerByEmail(customerEmail);
        //Then
        assertThat(actualCustomer).isEqualTo(expectedCustomer);
        System.out.println(expectedCustomer);
        System.out.println(actualCustomer);
    }

//    @Test
//    void shouldAddCustomerToCustomerList(){
//        //Given
//        Customer customer = new Customer(1, "Dylan", "Brook", "brook1@hotmail.com", "pass123word");
//        List<Customer> customers = Arrays.asList(customer);
//        when(customerDAO.selectAllCustomers()).thenReturn(customers);
//        //When
//
//        //Then
//    }
}
