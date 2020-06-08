package com.example.ecnu_time_bank.service;

import com.example.ecnu_time_bank.entity.User;
import com.example.ecnu_time_bank.mapper.UserMapper;
import com.example.ecnu_time_bank.utils.Result;
import com.example.ecnu_time_bank.utils.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result selectByID(Integer ID) {
        User user = userMapper.selectByPrimaryKey(ID);
        if (user==null){
            return ResultFactory.buildFailResult("未找到该用户,userID = " + ID);
        }
        else{
            return ResultFactory.buildSuccessResult(user);
        }

    }

    @Override
    public Result selectAllUser() {
        List<User> userList = userMapper.selectAllUser();
        if (userList.isEmpty()){
            return ResultFactory.buildFailResult("不存在用户");
        }
        else{
            return ResultFactory.buildSuccessResult(userList);
        }
    }

    @Override
    public Result selectByUserName(String userName) {
        List<User> userList = userMapper.selectByUserName(userName);
        if (userList.isEmpty()){
            return ResultFactory.buildFailResult("未找到用户,username = " + userName);
        }
        else{
            return ResultFactory.buildSuccessResult(userList);
        }
    }

    @Override
    public Result deleteByID(Integer ID) {
        User user = userMapper.selectByPrimaryKey(ID);
        if (user==null){
            return ResultFactory.buildFailResult("未找到该用户,userID = " + ID);
        }
        else{
            userMapper.deleteByPrimaryKey(ID);
            return ResultFactory.buildSuccessResult(null);
        }
    }

    @Override
    public Result updata(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        int ID = user.getUserId();
        User newUser = userMapper.selectByPrimaryKey(ID);
        if (newUser==null){
            return ResultFactory.buildFailResult("修改用户失败");
        }
        else{
            return ResultFactory.buildSuccessResult(newUser);
        }
    }

    @Override
    public Result add(User user) {
        List<User> userList = userMapper.selectByUserName(user.getUserName());
        if(userList.isEmpty()){
            userMapper.insert(user);
            return ResultFactory.buildSuccessResult(user);
        }
        else {
            return ResultFactory.buildFailResult("已存在该用户名的用户");
        }
    }


}
