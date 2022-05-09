package com.infynicode.department.controller;

import com.infynicode.department.model.DepartmentMO;
import com.infynicode.department.service.DepartmentService;
import com.infynicode.department.utility.DepartmentConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(DepartmentConstants.DEPARTMENT_CONTEXT_PATH)
public class DepartmentController {

    private final DepartmentService departmentService;


    @PostMapping
    public ResponseEntity<DepartmentMO> saveDepartment(@RequestBody DepartmentMO input) {
        return new ResponseEntity<>(departmentService.saveDepartment(input),
                HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<DepartmentMO>> getAllDepartmentData() {
        return new ResponseEntity<>(departmentService.getAllDepartmentData(),
                HttpStatus.OK);
    }

    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentMO> getSingleDepartment(@PathVariable("departmentId") Integer departmentId) {
        return new ResponseEntity<>(departmentService.getSingleDepartment(departmentId),
                HttpStatus.OK);
    }

    @GetMapping("/hospital/{hospitalId}")
    public ResponseEntity<List<DepartmentMO>> getDepartments(@PathVariable("hospitalId") Integer hospitalId) {
        return new ResponseEntity<>(departmentService.getDepartments(hospitalId),
                HttpStatus.OK);
    }


}
