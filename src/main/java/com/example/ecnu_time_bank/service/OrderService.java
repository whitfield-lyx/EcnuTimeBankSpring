package com.example.ecnu_time_bank.service;

import com.example.ecnu_time_bank.entity.Order;
import com.example.ecnu_time_bank.utils.Result;

import java.util.List;

public interface OrderService {
    public Order selectByID(Integer ID);

    public Result deleteByID(Integer ID);

    public Result update(Order order);

    public Result add(Order order);

    List<Order> selectTenOrder(int offset);

    List<Order> selectTenOrderByType(String type, int offset);
}
