package com.example.ecnu_time_bank.mapper;

import com.example.ecnu_time_bank.entity.Order;
import com.example.ecnu_time_bank.entity.User;
import org.apache.ibatis.annotations.Select;

public interface OrderMapper {

    int insert(Order record);

    int insertSelective(Order record);

    @Select("select * from `order` where order_id=#{orderId}")
    Order selectById(Integer orderId);
}