package com.example.ecnu_time_bank.mapper;

import com.example.ecnu_time_bank.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByPrimaryKey(Integer userId);

    List<User> selectByConditions(User user);

    List<User> selectByUserName(String userName);

    User selectByTelephone(String userTelephone);

    List<User> selectAllUser();
}
