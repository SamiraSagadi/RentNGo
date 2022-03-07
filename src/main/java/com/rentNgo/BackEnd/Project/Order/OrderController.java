package com.rentNgo.BackEnd.Project.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "order")
@RestController
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "/create-new-order")
    void createOrder(@RequestBody Order order) {
        System.out.println("POST REQUEST.....");
        orderService.createOrder(order);
        System.out.println(order);
    }

    @PutMapping(path = "edit/{orderId}")
    public void updateOrder(@PathVariable("orderId") Integer orderId, @RequestBody Order order) {
        System.out.println("UPDATE REQUEST.....");
        orderService.updateOrder(orderId, order);
    }

    @DeleteMapping(path = "/delete/{orderId}")
    void deleteOrderById(@PathVariable("orderId") Integer orderId) {
        System.out.println("DELETE REQUEST FOR ORDER WITH ID: " + orderId);
        orderService.deleteOrder(orderId);
    }
}
