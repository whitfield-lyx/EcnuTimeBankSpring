package com.example.ecnu_time_bank.service;

import com.example.ecnu_time_bank.entity.VolunteerFor;
import com.example.ecnu_time_bank.utils.Result;

public interface VolunteerForService {

    Result selectByID(Integer ID);

    Result selectAllVolunteerFor();

    Result selectByOrderID(Integer OrderId);

    Result deleteByTwoID(Integer orderId,Integer volunteerId);

    Result updata(VolunteerFor volunteerFor);

    Result add(VolunteerFor volunteerFor);
}



