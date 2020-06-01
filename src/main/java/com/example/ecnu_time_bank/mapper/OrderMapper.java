package com.example.ecnu_time_bank.mapper;

import com.example.ecnu_time_bank.entity.Order;

public interface OrderMapper {
    int insert(Order record);

    int insertSelective(Order record);
}