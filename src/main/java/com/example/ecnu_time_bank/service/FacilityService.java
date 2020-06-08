package com.example.ecnu_time_bank.service;

import com.example.ecnu_time_bank.entity.Facility;
import com.example.ecnu_time_bank.entity.User;
import com.example.ecnu_time_bank.utils.Result;
import org.springframework.stereotype.Service;


public interface FacilityService {

    Result selectByID(Integer ID);

    Result selectAllFacility();

    Result selectByFacilityName(String UserName);

    Result deleteByID(Integer ID);

    Result updata(Facility facility);

    Result add(Facility facility);
}
