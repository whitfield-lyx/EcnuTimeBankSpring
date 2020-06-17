package com.example.ecnu_time_bank.service;

import com.example.ecnu_time_bank.entity.VolunteerFor;
import com.example.ecnu_time_bank.mapper.VolunteerForMapper;
import com.example.ecnu_time_bank.utils.Result;
import com.example.ecnu_time_bank.utils.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VolunteerForServiceImpl implements VolunteerForService {
    @Autowired
    private VolunteerForMapper volunteerForMapper;

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
        if (volunteerForList.isEmpty()) {
            return ResultFactory.buildFailResult("不存在志愿服务关系");
        } else {
            return ResultFactory.buildSuccessResult(volunteerForList);
        }
    }

    @Override
    public Result deleteByID(Integer ID) {
        VolunteerFor volunteerFor = volunteerForMapper.selectByPrimaryKey(ID);
        if (volunteerFor == null) {
            return ResultFactory.buildFailResult("未找到该志愿服务关系,volunteerForID = " + ID);
        } else {
            volunteerForMapper.deleteByPrimaryKey(ID);
            return ResultFactory.buildSuccessResult(null);
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


