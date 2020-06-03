package com.example.ecnu_time_bank.controller;

import com.example.ecnu_time_bank.entity.Order;
import com.example.ecnu_time_bank.entity.User;
import com.example.ecnu_time_bank.service.OrderService;
import com.example.ecnu_time_bank.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/order/{ID}")
    public Order getOrderById(@PathVariable Integer ID) {
        return orderService.selectByID(ID);

    }
}
