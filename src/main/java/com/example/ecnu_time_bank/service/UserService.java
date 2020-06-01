package com.example.ecnu_time_bank.service;

import com.example.ecnu_time_bank.entity.User;

public interface UserService {

    public User selectByID(Integer ID);
    public int deleteByID(Integer ID);
    public User updata(User user);
    public User add(User user);

}
