package com.example.ecnu_time_bank.mapper;


import com.example.ecnu_time_bank.entity.VolunteerFor;

import java.util.List;

public interface VolunteerForMapper {
    int deleteByPrimaryKey(Integer volunteerForId);

    int deleteByTwoId(Integer orderId,Integer userId);

    int insert(VolunteerFor record);

    int insertSelective(VolunteerFor record);

    List<VolunteerFor> selectByOrderId(Integer OrderId);

    List<VolunteerFor> selectAllVolunteerFor();

    VolunteerFor selectByPrimaryKey(Integer volunteerForId);

    VolunteerFor selectByTwoId(Integer orderId,Integer volunteerId);

    int updateByPrimaryKeySelective(VolunteerFor record);

    int updateByPrimaryKey(VolunteerFor record);
}
