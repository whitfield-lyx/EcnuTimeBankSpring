package com.example.ecnu_time_bank.controller;


import com.example.ecnu_time_bank.entity.VolunteerFor;
import com.example.ecnu_time_bank.service.VolunteerForService;
import com.example.ecnu_time_bank.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/volunteerFor")
public class VolunteerForController {
        @Autowired
        private VolunteerForService volunteerForService;

        @GetMapping("")
        @ResponseStatus(HttpStatus.OK)
        public Result getVolunteerFor()
        {
            return volunteerForService.selectAllVolunteerFor();
        }

        @GetMapping("/{OrderId}")
        @ResponseStatus(HttpStatus.OK)
        public Result getVolunteerForByOrderId(@PathVariable("OrderId") Integer OrderId) { return volunteerForService.selectByOrderID(OrderId); }

        @PostMapping("")
        @ResponseStatus(HttpStatus.CREATED)
        public Result addVolunteerFor(@RequestBody VolunteerFor volunteerFor) {
            return volunteerForService.add(volunteerFor);
        }

        @DeleteMapping("/{volunteerForID}")
        @ResponseStatus(HttpStatus.OK)
        public Result deleteVolunteerFor(@PathVariable("volunteerForID") Integer ID){
            return volunteerForService.deleteByID(ID);
        }

        @PutMapping("/update")
        @ResponseStatus(HttpStatus.CREATED)
        public Result updateVolunteerFor(@RequestBody VolunteerFor volunteerFor){
            return volunteerForService.updata(volunteerFor);
        }
}
