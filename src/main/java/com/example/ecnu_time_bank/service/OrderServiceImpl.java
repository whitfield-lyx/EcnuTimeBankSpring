package com.example.ecnu_time_bank.service;

import com.example.ecnu_time_bank.entity.Order;
import com.example.ecnu_time_bank.entity.User;
import com.example.ecnu_time_bank.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderMapper orderMapper;

    @Override
    public Order selectByID(Integer ID) {
        return orderMapper.selectById(ID);

    }

    @Override
    public int deleteByID(Integer ID) {
        return 0;
    }

    @Override
    public Order update(User user) {
        return null;
    }

    @Override
    public Order add(User user) {
        return null;
    }
}
