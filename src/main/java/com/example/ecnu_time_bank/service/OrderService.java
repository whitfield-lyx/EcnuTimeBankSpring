package com.example.ecnu_time_bank.service;

import com.example.ecnu_time_bank.entity.Order;
import com.example.ecnu_time_bank.entity.User;

public interface OrderService {
    public Order selectByID(Integer ID);
    public int deleteByID(Integer ID);
    public Order update(User user);
    public Order add(User user);
}
