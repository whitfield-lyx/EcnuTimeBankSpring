package com.example.ecnu_time_bank.service;

import com.example.ecnu_time_bank.entity.Order;
import com.example.ecnu_time_bank.mapper.OrderMapper;
import com.example.ecnu_time_bank.utils.Result;
import com.example.ecnu_time_bank.utils.ResultCode;
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
    public Result selectByID(Integer ID) {
        Order result = orderMapper.selectById(ID);
        if (result == null) {
            return ResultFactory.buildFailResult("未找到该需求,orderId = " + ID);
        } else {
            return ResultFactory.buildSuccessResult(result);
        }
    }

    @Override
    public Result deleteByID(Integer ID) {
        int result = orderMapper.delete(ID);
        if (result == 0) {
            return ResultFactory.buildFailResult("未找到该需求,orderId = " + ID);
        } else {
            return ResultFactory.buildResult(ResultCode.SUCCESS, "删除成功 OrderId = " + ID, null);
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
        Order newOrder = orderMapper.selectById(order.getOrderId());
        if (result == 0) {
            return ResultFactory.buildFailResult("未成功更新该需求,orderId = " + order.getOrderId());
        } else {
            return ResultFactory.buildSuccessResult(newOrder);
        }
    }
    @Override
    public Result cancelOrder(Integer orderId){
        Order orderExisted = orderMapper.selectById(orderId);
        if (orderExisted == null) {
            return ResultFactory.buildFailResult("错误的orderId: " +orderId);
        }
        int result = orderMapper.cancelOrder(orderExisted);
        if (result == 0) {
            return ResultFactory.buildFailResult("未成功取消该需求,orderId = " +orderExisted.getOrderId());
        } else {
            return ResultFactory.buildSuccessResult(orderExisted.getOrderId());
        }
    }
    @Override
    public Result add(Order order) {
//        todo null值要有默认值
        setOrderPublishedTime(order);
        order.setOrderState("发布中");
        int result = orderMapper.insert(order);
        if (result == 0) {
            return ResultFactory.buildFailResult("需求添加失败,orderId = " + order.getOrderId());
        } else {
            return ResultFactory.buildSuccessResult(order);
        }
    }

    private void setOrderPublishedTime(Order order) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        order.setOrderPubleshedTime(Timestamp.valueOf(simpleDateFormat.format(new Date())));
    }

    @Override
    public Result selectTenOrder(int offset) {
        List<Order> orderList = orderMapper.selectTenOrder(offset);
        if (orderList.isEmpty()) {
            return ResultFactory.buildFailResult("不存在订单");
        } else {
            return ResultFactory.buildSuccessResult(orderList);
        }
    }

    @Override
    public Result selectTenOrderByType(String type, int offset) {
        List<Order> orderList = orderMapper.selectTenOrderByType(type, offset);
        if (orderList.isEmpty()) {
            return ResultFactory.buildFailResult("不存在符合要求的订单");
        } else {
            return ResultFactory.buildSuccessResult(orderList);
        }
    }

    @Override
    public Result selectTenAcceptedOrderByUserId(Integer userId, int offset) {
        List<Order> orders = orderMapper.selectTenAcceptedOrderByUserId(userId, offset);
        if (orders.isEmpty()) {
            return ResultFactory.buildFailResult("不存在符合要求的订单");
        } else {
            return ResultFactory.buildSuccessResult(orders);
        }
    }

    @Override
    public Result selectTenPublishedOrderByUserId(Integer userId, int offset) {
        List<Order> orders = orderMapper.selectTenPublishedOrderByUserId(userId, offset);
        if (orders.isEmpty()) {
            return ResultFactory.buildFailResult("不存在符合要求的订单");
        } else {
            return ResultFactory.buildSuccessResult(orders);
        }
    }
}
