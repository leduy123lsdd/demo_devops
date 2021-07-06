package com.devops.demo_devops.Controllers;

import com.devops.demo_devops.Reposotories.OrderRepository;
import com.devops.demo_devops.Tables.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//@EnableAsync
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    //TODO: Get all order
    @GetMapping("/order")
    List<Orders> getAllOrder(){
        return orderRepository.findAll();
    }

    //TODO: Get order by customerNumber
    @GetMapping("/order/{customerNumber}")
    List<Orders> getOrderByCustomerNumber(@PathVariable int customerNumber) {
        return orderRepository.findByCustomerNumber(customerNumber);
    }

    //TODO: Add new order
    @PostMapping("/order/create")
    Orders createOrder(@RequestBody Map<String, String> body) {
        int customerNumber = Integer.parseInt(body.get("customerNumber"));
        int productCode = Integer.parseInt(body.get("productCode"));
        String orderDate = body.get("orderDate");
        String status = body.get("status");

        Orders new_order = new Orders(customerNumber, productCode, orderDate, status);

        return orderRepository.save(new_order);
    }

    //TODO: Update status
//    @Async
    @PostMapping("/order/updateStatus")
    List<Orders> updateStatus(@RequestBody Map<String, String> body) throws InterruptedException {
        int orderNumber = Integer.parseInt(body.get("orderNumber"));
        String statusCode = body.get("status");
        int customerNumber = Integer.parseInt(body.get("customerNumber"));

        orderRepository.updateOrderStatus(orderNumber, statusCode);

        Thread.sleep(2000);

        return orderRepository.findByCustomerNumber(customerNumber);
    }

}

