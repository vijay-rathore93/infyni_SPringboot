package com.infynicode.hospital.controller;


import com.infynicode.hospital.model.HospitalMO;
import com.infynicode.hospital.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/api/v1/test")
@RequiredArgsConstructor
public class TestController {

    private final HospitalService hospitalService;

    @GetMapping("/")
    public String getMessage(){
        return "hello";
    }

    @GetMapping("/zero")
    @ResponseBody
    public List<HospitalMO> getMessage0(){
        return hospitalService.getAllHospitals();
    }

    @GetMapping("/one")
    public  @ResponseBody String getMessage1(){
        return "hello";
    }

    @GetMapping("/two")
    public ResponseEntity<String> getMessage2(){
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }


// if we are using @Controller alone then watever the response returning by api,
// it will check template corresponding to return value.
//@RestController=@Controller+@ResponseBody
//@RestController=@Controller+ResponseEntity



}
