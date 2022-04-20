package com.infynicode.hospital.controller;

import com.infynicode.hospital.service.HospitalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;


//    //constructor autowiring
//    private HospitalService hospitalService2;
//
//    @Autowired
//    public void setHospitalService2(HospitalService hospitalService2) {
//        this.hospitalService2 = hospitalService2;
//    }
//
//   @Autowired
//    public HospitalController(HospitalService hospitalService2) {
//        this.hospitalService2 = hospitalService2;
//    }



}
