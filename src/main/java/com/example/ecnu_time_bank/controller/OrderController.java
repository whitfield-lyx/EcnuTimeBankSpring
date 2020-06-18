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
    public Result getOrderById(@PathVariable Integer orderId) {
        return orderService.selectByID(orderId);
    }

    @GetMapping("/offset/{offset}")
    public Result getTenOrderOrderedByTime(@PathVariable Integer offset) {
        return orderService.selectTenOrder(offset);
    }

    @PostMapping("")
    public Result addNewOrder(@RequestBody Order order) {
        return orderService.add(order);
    }
    @PutMapping("")
    public Result updateOrder(@RequestBody Order order) {
        return orderService.update(order);
    }

    @PutMapping("/cancelOrder/{orderId}")
    public Result cancelOrder(@PathVariable Integer orderId) {
        return orderService.cancelOrder(orderId);
    }
    @PutMapping("/confirmOrder")
    public Result confirmOrder(Integer orderId,Integer volunteerId) {
        return orderService.confirmOrder(orderId,volunteerId);
    }
    @DeleteMapping("/{orderId}")
    public Result deleteOrder(@PathVariable Integer orderId) {
        return orderService.deleteByID(orderId);
    }

    @GetMapping("/type/{type}/offset/{offset}")
    public Result getTenOrderByType(@PathVariable String type, @PathVariable Integer offset) {
        return orderService.selectTenOrderByType(type, offset);
    }

    @GetMapping("/accepted/{userId}/offset/{offset}")
    public Result getAcceptedOrderByUserId(@PathVariable Integer userId, @PathVariable Integer offset) {
        return orderService.selectTenAcceptedOrderByUserId(userId, offset);
    }

    @GetMapping("/published/{userId}/offset/{offset}")
    public Result getPublishedOrderByUserId(@PathVariable Integer userId, @PathVariable Integer offset) {
        return orderService.selectTenPublishedOrderByUserId(userId, offset);
    }

}
