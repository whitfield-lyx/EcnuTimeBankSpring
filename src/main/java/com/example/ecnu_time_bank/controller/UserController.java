package com.example.ecnu_time_bank.controller;


import com.example.ecnu_time_bank.entity.User;
import com.example.ecnu_time_bank.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/user")
    public String test() {
        return "hello Spring Boot!";
    }

    @GetMapping("/user/{ID}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserByID(@PathVariable("ID") Integer ID)
    {
        return userService.selectByID(ID);
    }
}
