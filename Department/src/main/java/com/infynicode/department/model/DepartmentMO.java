package com.infynicode.department.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentMO {
    private Integer deptId;
    private String deptName;
    private String deptCode;
    private String description;
    private String deptHod;
    private Integer hospitalId;
    //private List<PatientMO> patients;
}
