package com.example.ecnu_time_bank.mapper;

import com.example.ecnu_time_bank.entity.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    @Insert("insert into `order`(order_id,order_title,order_publeshed_time,order_description," +
            "order_type,order_time,order_address,order_telephone,order_bonus,order_publisher_id," +
            "order_state) values (#{orderId},#{orderTitle},#{orderPubleshedTime},#{orderDescription}," +
            "#{orderType},#{orderTime}," +
            "#{orderAddress},#{orderTelephone},#{orderBonus},#{orderPublisherId},#{orderState})")
    int insert(Order record);


// to do   int insertSelective(Order record);

    @Select("select * from `order` where order_id=#{orderId}")
    Order selectById(Integer orderId);

    @Select("select * from `order` where order_type=#{type} order by order_time limit #{offset},10")
    List<Order> selectTenOrderByType(String type, int offset);

    @Select("select * from `order` order by order_time limit #{offset},10")
    List<Order> selectTenOrder(int offset);

    @Select("select * from `order` where order_accpeters_id=#{userId} order by order_time limit #{offset},10")
    List<Order> selectTenAcceptedOrderByUserId(Integer userId, int offset);

    @Select("select * from `order` where order_publisher_id=#{userId} order by order_time limit #{offset},10")
    List<Order> selectTenPublishedOrderByUserId(Integer userId, int offset);

    @Select("select * from `order` where order_title like #{keyword} order by order_time")
    List<Order> selectAllOrderBySearchOnTitle(String keyword);

    @Select("select * from `order` where order_description like #{keyword} order by order_time")
    List<Order> selectAllOrderBySearchOnDescription(String keyword);

    @Select("select * from `order` where order_address like #{keyword} order by order_time")
    List<Order> selectAllOrderBySearchOnAddress(String keyword);

    @Delete("delete from `order` where order_id=#{orderId}")
    int delete(Integer orderId);

    @Update("update `order` set order_title=#{orderTitle}," +
            "order_description=#{orderDescription}," +
            "order_time=#{orderTime}," +
            "order_bonus=#{orderBonus}," +
            "order_telephone=#{orderTelephone}," +
            "order_type=#{orderType}," +
            "order_address=#{orderAddress}," +
            "order_accpeters_id=#{orderAccpetersId} where order_id=#{orderId}")
    int update(Order order);


    @Update("UPDATE `order` " +
            "SET order_accpeters_id = 0 " +
            "WHERE order_id = #{orderId} ")
    int cancelOrder(Order order);

    //用于确定订单的执行志愿者
    @Update("UPDATE `order` " +
            "SET order_accpeters_id = #{volunteerId} " +
            "WHERE order_id = #{orderId} ")
    int comfirmlOrder(Integer orderId, Integer volunteerId);
}
