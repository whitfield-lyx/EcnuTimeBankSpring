package com.example.ecnu_time_bank.controller;


import com.example.ecnu_time_bank.entity.User;
import com.example.ecnu_time_bank.service.UserServiceImpl;
import com.example.ecnu_time_bank.utils.Result;
import com.example.ecnu_time_bank.utils.ResultCode;
import com.example.ecnu_time_bank.utils.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    public Result getUserByUserName(@PathVariable("userID") Integer userID) {
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
    public Result registerUser(@RequestBody User user) {
        return userService.register(user);
    }

    /**
     * 用户登录
     * @param telephone
     * @param password
     * @return
     */

    @PostMapping("/login")
    public Result loginUser(String telephone, String password, HttpSession session){
        return userService.login(telephone,password);
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{userID}")
    @ResponseStatus(HttpStatus.OK)
    public Result deleteUser(@PathVariable("userID") Integer ID){
        return userService.deleteByID(ID);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Result updateUser(@RequestBody User user){
        return userService.updata(user);
    }
}
