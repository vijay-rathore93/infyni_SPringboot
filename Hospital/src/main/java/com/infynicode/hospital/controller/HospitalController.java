package com.infynicode.hospital.controller;

import com.infynicode.hospital.service.HospitalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;


   /* @Autowired
    private  HospitalService hospitalService1;


    private HospitalService hospitalService2;


    @Autowired
    public HospitalController(HospitalService hospitalService2) {
        this.hospitalService2 = hospitalService2;
    }*/
}
