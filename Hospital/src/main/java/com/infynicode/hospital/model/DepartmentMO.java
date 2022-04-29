package com.infynicode.hospital.model;

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
    private Integer id;
    private String name;
    private String hod;
    private List<PatientMO> patients;
}
