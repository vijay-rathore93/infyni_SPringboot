package com.infynicode.hospital.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientMO {

    private Integer id;
    private String name;
    private String fullName;
    private String problems;
    private String address;
}
