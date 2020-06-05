package com.example.ecnu_time_bank.controller;

import com.example.ecnu_time_bank.entity.Order;
import com.example.ecnu_time_bank.service.OrderService;
import com.example.ecnu_time_bank.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/{orderId}")
    public Order getOrderById(@PathVariable Integer orderId) {
        return orderService.selectByID(orderId);
    }

    @GetMapping("/offset/{offset}")
    public List<Order> getTenOrderOrderedByTime(@PathVariable Integer offset) {
        return orderService.selectTenOrder(offset);
    }

    @PostMapping("")
    public Result addNewOrder(@RequestBody Order order) {
        return orderService.add(order);
    }

    @PutMapping("")
    public Result updateOrder(@RequestBody Order order) {
//        todo 检查是否存在order_id
        return orderService.update(order);
    }

    @DeleteMapping("/{orderId}")
    public Result deleteOrder(@PathVariable Integer orderId) {
        return orderService.deleteByID(orderId);
    }

    @GetMapping("/type/{type}/offset/{offset}")
    public List<Order> getTenOrderByType(@PathVariable String type, @PathVariable Integer offset) {
        return orderService.selectTenOrderByType(type, offset);
    }
}
