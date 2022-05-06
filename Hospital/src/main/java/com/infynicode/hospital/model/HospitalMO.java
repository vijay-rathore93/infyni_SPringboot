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
public class HospitalMO {

    private Integer id;
    private String name;
    private String code;
    private String state;
    private String city;
    private String country;
    private Integer zipCode;
    private String addressLine1;
    private String addressLine2;
    private String streetName;
    private List<DepartmentMO> departments;
}
