package com.example.ecnu_time_bank.service;

import com.example.ecnu_time_bank.entity.User;
import com.example.ecnu_time_bank.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByID(Integer ID) {
        return userMapper.selectByPrimaryKey(ID);
    }

    @Override
    public int deleteByID(Integer ID) {
        return userMapper.deleteByPrimaryKey(ID);
    }

    @Override
    public User updata(User user) {
        userMapper.updateByPrimaryKey(user);
        return user;
    }

    @Override
    public User add(User user) {
        userMapper.insert(user);
        return user;
    }


}
