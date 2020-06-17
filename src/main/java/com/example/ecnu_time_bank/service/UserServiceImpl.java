package com.example.ecnu_time_bank.service;

import com.example.ecnu_time_bank.entity.User;
import com.example.ecnu_time_bank.mapper.UserMapper;
import com.example.ecnu_time_bank.utils.Result;
import com.example.ecnu_time_bank.utils.ResultCode;
import com.example.ecnu_time_bank.utils.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Result selectByConditions(User user) {
        List<User> users = userMapper.selectByConditions(user);
        if (users.isEmpty()){
            return ResultFactory.buildFailResult("未找到用户");
        }
        else{
            return ResultFactory.buildSuccessResult(users);
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

    @Override
    public Result register(User user) {
        User existUser = userMapper.selectByTelephone(user.getUserTelephone());
        if(existUser==null){
            user.setUserBalance(0.0);
            userMapper.insert(user);
            existUser = userMapper.selectByTelephone(user.getUserTelephone());
            return ResultFactory.buildSuccessResult(existUser);
        }
        else {
            return ResultFactory.buildFailResult("已存在手机号的用户");
        }
    }

    @Override
    public Result login(String telephone, String password) {
        User curUser = userMapper.selectByTelephone(telephone);
        String curPassWord;
        if(curUser==null){
            return ResultFactory.buildFailResult("不存在该用户");
        }
        else{
            curPassWord = curUser.getUserPassword();
            if (curPassWord.equals(password)){
                return ResultFactory.buildResult(ResultCode.SUCCESS,"登录成功",curUser);
            }
            else{
                return ResultFactory.buildFailResult("密码错误");
            }
        }

    }
}
