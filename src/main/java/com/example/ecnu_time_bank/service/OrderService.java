package com.example.ecnu_time_bank.service;

import com.example.ecnu_time_bank.entity.Order;
import com.example.ecnu_time_bank.utils.Result;

import java.util.List;

public interface OrderService {
    Result selectByID(Integer ID);

    Result deleteByID(Integer ID);

    Result update(Order order);

    Result add(Order order);

    Result selectTenOrder(int offset);

    Result selectTenOrderByType(String type, int offset);

    Result selectTenAcceptedOrderByUserId(Integer userId, int offset);

    Result selectTenPublishedOrderByUserId(Integer userId, int offset);
}
