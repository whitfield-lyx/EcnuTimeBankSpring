package com.example.ecnu_time_bank.service;

import com.example.ecnu_time_bank.entity.Order;
import com.example.ecnu_time_bank.mapper.OrderMapper;
import com.example.ecnu_time_bank.utils.Result;
import com.example.ecnu_time_bank.utils.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public Order selectByID(Integer ID) {
        return orderMapper.selectById(ID);
    }

    @Override
    public Result deleteByID(Integer ID) {
        int result = orderMapper.delete(ID);
        if (result == 0) {
            return ResultFactory.buildFailResult("未找到该需求,orderId = " + ID);
        } else {
            return ResultFactory.buildSuccessResult("用户,orderId = " + ID + " 删除成功");
        }
    }

    @Override
    public Result update(Order order) {
        Order orderExisted = orderMapper.selectById(order.getOrderId());
        if (orderExisted == null) {
            return ResultFactory.buildFailResult("错误的orderId: " + order.getOrderId());
        }
        orderExisted.setOrderBonus(order.getOrderBonus() != null ? order.getOrderBonus() : orderExisted.getOrderBonus());
        orderExisted.setOrderTime(order.getOrderTime() != null ? order.getOrderTime() : orderExisted.getOrderTime());
        orderExisted.setOrderTitle(order.getOrderTitle() != null ? order.getOrderTitle() : orderExisted.getOrderTitle());
        orderExisted.setOrderTelephone(order.getOrderTelephone() != null ? order.getOrderTelephone() : orderExisted.getOrderTelephone());
        orderExisted.setOrderType(order.getOrderBonus() != null ? order.getOrderType() : orderExisted.getOrderType());
        orderExisted.setOrderDescription(order.getOrderDescription() != null ? order.getOrderDescription() : orderExisted.getOrderDescription());
        orderExisted.setOrderAddress(order.getOrderAddress() != null ? order.getOrderAddress() : orderExisted.getOrderAddress());
        int result = orderMapper.update(orderExisted);
        if (result == 0) {
            return ResultFactory.buildFailResult("未成功更新该需求,orderId = " + order.getOrderId());
        } else {
            return ResultFactory.buildSuccessResult("用户,orderId = " + order.getOrderId() + " 更新成功");
        }
    }

    @Override
    public Result add(Order order) {
        setOrderPublishedTime(order);
        order.setOrderState("发布中");
        int result = orderMapper.insert(order);
        if (result == 0) {
            return ResultFactory.buildFailResult("需求添加失败,orderId = " + order.getOrderId());
        } else {
            return ResultFactory.buildSuccessResult("需求添加成功,orderId = " + order.getOrderId());
        }
    }

    private void setOrderPublishedTime(Order order) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order.setOrderPubleshedTime(Timestamp.valueOf(simpleDateFormat.format(new Date())));
    }

    @Override
    public List<Order> selectTenOrder(int offset) {
        return orderMapper.selectTenOrder(offset);
    }

    @Override
    public List<Order> selectTenOrderByType(String type, int offset) {
        return orderMapper.selectTenOrderByType(type, offset);
    }
}
