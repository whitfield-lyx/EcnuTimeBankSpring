package com.example.ecnu_time_bank.service;

import com.example.ecnu_time_bank.entity.User;
import com.example.ecnu_time_bank.utils.Result;

import java.util.List;


public interface UserService {

    User selectByID(Integer ID);
    List<User> selectAllUser();
    List<User> selectByUserName(String UserName);
    Result deleteByID(Integer ID);
    Result updata(User user);
    /**
     * 添加(注册)用户
     * @param user
     * @return Result
     */
    Result add(User user);

}
