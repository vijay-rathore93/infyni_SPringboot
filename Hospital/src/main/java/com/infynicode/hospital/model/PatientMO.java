package com.infynicode.hospital.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include. NON_NULL)
public class PatientMO {

    private Integer id;
    private String name;
    private String fullName;
    private String problems;
    private String address;
}
