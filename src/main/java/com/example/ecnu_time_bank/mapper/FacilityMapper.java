package com.example.ecnu_time_bank.mapper;

import com.example.ecnu_time_bank.entity.Facility;

public interface FacilityMapper {
    int deleteByPrimaryKey(Integer facilityId);
    int insert(Facility record);
    int insertSelective(Facility record);
    Facility selectByPrimaryKey(Integer facilityId);
    int updateByPrimaryKeySelective(Facility record);
    int updateByPrimaryKey(Facility record);
}
