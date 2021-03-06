package com.example.ecnu_time_bank.service;

import com.example.ecnu_time_bank.entity.User;
import com.example.ecnu_time_bank.entity.VolunteerFor;
import com.example.ecnu_time_bank.mapper.UserMapper;
import com.example.ecnu_time_bank.mapper.VolunteerForMapper;
import com.example.ecnu_time_bank.utils.Result;
import com.example.ecnu_time_bank.utils.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class VolunteerForServiceImpl implements VolunteerForService {

    @Autowired
    private VolunteerForMapper volunteerForMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Result selectByID(Integer ID) {
        VolunteerFor volunteerFor = volunteerForMapper.selectByPrimaryKey(ID);
        if (volunteerFor == null) {
            return ResultFactory.buildFailResult("未找到该志愿服务关系,volunteerForID = " + ID);
        } else {
            return ResultFactory.buildSuccessResult(volunteerFor);
        }

    }

    @Override
    public Result selectAllVolunteerFor() {
        List<VolunteerFor> volunteerForList = volunteerForMapper.selectAllVolunteerFor();
        if (volunteerForList.isEmpty()) {
            return ResultFactory.buildFailResult("不存在志愿服务关系");
        } else {
            return ResultFactory.buildSuccessResult(volunteerForList);
        }
    }

    @Override
    public Result selectByOrderID(Integer OrderId) {
        List<VolunteerFor> volunteerForList = volunteerForMapper.selectByOrderId(OrderId);
        List<User> volunteersList = new ArrayList<>();
        if (volunteerForList.isEmpty()) {
            return ResultFactory.buildFailResult("不存在志愿服务关系");
        } else {
            for(VolunteerFor volunteerFor : volunteerForList){
                volunteersList.add(userMapper.selectByPrimaryKey(volunteerFor.getVolunteerId()));
            }
            return ResultFactory.buildSuccessResult(volunteersList);
        }
    }

    @Override
    public Result deleteByTwoID(Integer orderId,Integer volunteerId) {
        VolunteerFor volunteerFor = volunteerForMapper.selectByTwoId(orderId,volunteerId);
        if (volunteerFor == null) {
            return ResultFactory.buildFailResult("未找到该志愿服务关系,orderId = " +orderId+" & volunteerId = "+volunteerId);
        } else {
            volunteerForMapper.deleteByTwoId(orderId,volunteerId);
            return ResultFactory.buildSuccessResult(volunteerFor);
        }
    }

    @Override
    public Result updata(VolunteerFor volunteerFor) {
        volunteerForMapper.updateByPrimaryKeySelective(volunteerFor);
        int ID = volunteerFor.getVolunteerForId();
        VolunteerFor newVolunteerFor = volunteerForMapper.selectByPrimaryKey(ID);
        if (newVolunteerFor == null) {
            return ResultFactory.buildFailResult("志愿服务关系失败");
        } else {
            return ResultFactory.buildSuccessResult(newVolunteerFor);
        }
    }

    @Override
    public Result add(VolunteerFor volunteerFor) {
        if (volunteerFor!=null) {
            volunteerForMapper.insert(volunteerFor);
            return ResultFactory.buildSuccessResult(volunteerFor);
        } else {
            return ResultFactory.buildFailResult("已存在该志愿服务关系名的志愿服务关系");
        }
    }
}


