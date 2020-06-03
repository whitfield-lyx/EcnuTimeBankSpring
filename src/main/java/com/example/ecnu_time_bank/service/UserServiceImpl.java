package com.example.ecnu_time_bank.service;

import com.example.ecnu_time_bank.entity.User;
import com.example.ecnu_time_bank.mapper.UserMapper;

import com.example.ecnu_time_bank.utils.Result;
import com.example.ecnu_time_bank.utils.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByID(Integer ID) {
        return userMapper.selectByPrimaryKey(ID);
    }

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public List<User> selectByUserName(String userName) {
        List<User> userList = userMapper.selectByUserName(userName);
        return userList;
    }

    @Override
    public Result deleteByID(Integer ID) {
        User user = userMapper.selectByPrimaryKey(ID);
        if (user==null){
            return ResultFactory.buildFailResult("未找到该用户,userID = " + ID);
        }
        else{
            userMapper.deleteByPrimaryKey(ID);
            return ResultFactory.buildSuccessResult("用户,userID = "+ID+" 删除成功");
        }

    }

    @Override
    public Result updata(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        int ID = user.getUserId();
        return ResultFactory.buildSuccessResult("用户,userID = "+ID+" 修改成功");
    }

    @Override
    public Result add(User user) {
        List<User> userList = userMapper.selectByUserName(user.getUserName());
        if(userList.isEmpty()){
            userMapper.insert(user);
            return ResultFactory.buildSuccessResult("用户注册成功");
        }
        else {
            return ResultFactory.buildFailResult("已存在该用户名的用户");
        }
    }


}
