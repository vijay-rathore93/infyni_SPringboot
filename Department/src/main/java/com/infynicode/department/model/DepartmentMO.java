package com.infynicode.department.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.infynicode.department.entity.Auditable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include. NON_NULL)
public class DepartmentMO extends Auditable {
    private Integer deptId;
    private String deptName;
    private String deptCode;
    private String description;
    private String deptHod;
    private Integer hospitalId;
    //private List<PatientMO> patients;
}
