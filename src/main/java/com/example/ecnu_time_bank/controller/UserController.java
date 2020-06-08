package com.example.ecnu_time_bank.controller;


import com.example.ecnu_time_bank.entity.User;
import com.example.ecnu_time_bank.service.UserServiceImpl;
import com.example.ecnu_time_bank.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Result getUser()
    {
        return userService.selectAllUser();
    }
    /**
     * 根据用户名userName返回用户信息
     */
    @GetMapping("/{userID}")
    @ResponseStatus(HttpStatus.OK)
    public Result getUserByUserName(@PathVariable("userID") Integer userID)
    {
        return userService.selectByID(userID);
    }

    @GetMapping("/search")
    public Result getUserByConditions(@RequestBody User user){
        return userService.selectByConditions(user);
    }
    /**
     * 用户注册
     */
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public Result register(@RequestBody User user) {
        return userService.add(user);
    }
    /**
     * 删除用户
     */
    @DeleteMapping("/{userID}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("userID") Integer ID){
        return userService.deleteByID(ID);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Result updateNews(@RequestBody User user){
        return userService.updata(user);
    }
}
