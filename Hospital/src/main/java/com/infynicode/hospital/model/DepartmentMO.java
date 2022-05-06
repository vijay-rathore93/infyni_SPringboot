package com.infynicode.hospital.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include. NON_NULL)
public class DepartmentMO {
    private Integer deptId;
    private String deptName;
    private String deptCode;
    private String description;
    private String deptHod;

}
