package com.example.ecnu_time_bank.service;

import com.example.ecnu_time_bank.entity.User;
import com.example.ecnu_time_bank.utils.Result;

import java.util.List;
import java.util.Map;


public interface UserService {

    Result selectByID(Integer ID);

    Result selectAllUser();

    Result selectByUserName(String UserName);

    Result selectByConditions(User user);

    Result deleteByID(Integer ID);

    Result updata(User user);

    Result add(User user);

    Result login(String telephone, String password);

}
