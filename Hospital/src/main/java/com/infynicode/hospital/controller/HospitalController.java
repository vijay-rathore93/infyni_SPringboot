package com.infynicode.hospital.controller;

import com.infynicode.hospital.model.HospitalMO;
import com.infynicode.hospital.service.HospitalService;
import com.infynicode.hospital.utility.HospitalConstant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(HospitalConstant.HOSPITAL_CONTEXT_PATH)
public class HospitalController {

    private final HospitalService hospitalService;

    @PostMapping
    public ResponseEntity<HospitalMO> saveHospital(@RequestBody HospitalMO input) {
        return new ResponseEntity<>(hospitalService.createHospitalRecord(input),
                HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<HospitalMO>> allHospitalData() {
        return new ResponseEntity<>(hospitalService.getAllHospitals(),
                HttpStatus.OK);
    }

    @GetMapping("/{hospitalId}")
    public ResponseEntity<HospitalMO> getSingleHospital(@PathVariable("hospitalId") Integer hospitalId) {
        return new ResponseEntity<>(hospitalService.getSingleHospital(hospitalId),
                HttpStatus.OK);
    }


}
