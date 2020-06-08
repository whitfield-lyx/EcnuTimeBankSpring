package com.example.ecnu_time_bank.service;

import com.example.ecnu_time_bank.entity.Facility;
import com.example.ecnu_time_bank.entity.User;
import com.example.ecnu_time_bank.mapper.FacilityMapper;
import com.example.ecnu_time_bank.utils.Result;
import com.example.ecnu_time_bank.utils.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService {

    @Autowired
    private FacilityMapper facilityMapper;

    @Override
    public Result selectByID(Integer ID) {
        Facility facility = facilityMapper.selectByPrimaryKey(ID);
        if (facility == null) {
            return ResultFactory.buildFailResult("未找到该设施,facilityID = " + ID);
        } else {
            return ResultFactory.buildSuccessResult(facility);
        }

    }

    @Override
    public Result selectAllFacility() {
        List<Facility> facilityList = facilityMapper.selectAllFacility();
        if (facilityList.isEmpty()) {
            return ResultFactory.buildFailResult("不存在设施");
        } else {
            return ResultFactory.buildSuccessResult(facilityList);
        }
    }

    @Override
    public Result selectByFacilityName(String facilityName) {
        List<Facility> facilityList = facilityMapper.selectByFacilityName(facilityName);
        if (facilityList.isEmpty()) {
            return ResultFactory.buildFailResult("未找到设施,facilityName = " + facilityName);
        } else {
            return ResultFactory.buildSuccessResult(facilityList);
        }
    }

    @Override
    public Result deleteByID(Integer ID) {
        Facility facility = facilityMapper.selectByPrimaryKey(ID);
        if (facility == null) {
            return ResultFactory.buildFailResult("未找到该设施,facilityID = " + ID);
        } else {
            facilityMapper.deleteByPrimaryKey(ID);
            return ResultFactory.buildSuccessResult(null);
        }
    }



    @Override
    public Result updata(Facility facility) {
        facilityMapper.updateByPrimaryKeySelective(facility);
        int ID = facility.getFacilityId();
        Facility newFacility = facilityMapper.selectByPrimaryKey(ID);
        if (newFacility == null) {
            return ResultFactory.buildFailResult("修改设施失败");
        } else {
            return ResultFactory.buildSuccessResult(newFacility);
        }
    }

    @Override
    public Result add(Facility facility) {
        List<Facility> facilityList = facilityMapper.selectByFacilityName(facility.getFacilityName());
        if (facilityList.isEmpty()) {
            facilityMapper.insert(facility);
            return ResultFactory.buildSuccessResult(facility);
        } else {
            return ResultFactory.buildFailResult("已存在该设施名的设施");
        }

    }
}
