package com.example.ecnu_time_bank.controller;

import com.example.ecnu_time_bank.entity.Facility;
import com.example.ecnu_time_bank.service.FacilityService;
import com.example.ecnu_time_bank.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/facility")
public class FacilityController {

    @Autowired
    private FacilityService facilityService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Result getFacility()
    {
        return facilityService.selectAllFacility();
    }


    @GetMapping("/{facilityID}")
    @ResponseStatus(HttpStatus.OK)
    public Result getFacilityByFacilityName(@PathVariable("facilityID") Integer facilityID)
    {
        return facilityService.selectByID(facilityID);
    }


    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Result register(@RequestBody Facility facility) {
        return facilityService.add(facility);
    }

    @DeleteMapping("/{facilityID}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("facilityID") Integer ID){
        return facilityService.deleteByID(ID);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Result updateNews(@RequestBody Facility facility){
        return facilityService.updata(facility);
    }
}
