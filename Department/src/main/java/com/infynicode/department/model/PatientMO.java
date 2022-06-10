package com.infynicode.department.model;

import com.infynicode.department.entity.Auditable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientMO extends Auditable {

    private Integer id;
    private String name;
    private String fullName;
    private String problems;
    private String address;
}
