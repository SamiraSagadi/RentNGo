package com.rentNgo.BackEnd.Project.OrderDetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "order_detail")
public class OrderDetailController {
    private final OrderDetailService orderDetailService;

    @Autowired
    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @PostMapping(path = "/create-new-orderBasket")
    void createOrderBasket(@RequestBody OrderDetail orderDetail) {
        System.out.println("POST REQUEST.....");
        orderDetailService.createOrderBasket(orderDetail);
        System.out.println(orderDetail);
    }

    @PutMapping(path = "edit/{orderDetailId}")
    public void updateOrderBasket(@PathVariable("orderDetailId") Integer orderDetailId, @RequestBody OrderDetail orderDetail) {
        System.out.println("UPDATE REQUEST.....");
        orderDetailService.updateOrderBasket(orderDetailId, orderDetail);
    }

    @DeleteMapping(path = "/delete/{orderDetailId}")
    void deleteOrderBasket(@PathVariable("orderDetailId") Integer orderDetailId) {
        System.out.println("DELETE REQUEST FOR ORDER BASKET WITH ID: " + orderDetailId);
        orderDetailService.deleteOrderBasket(orderDetailId);
    }
}
