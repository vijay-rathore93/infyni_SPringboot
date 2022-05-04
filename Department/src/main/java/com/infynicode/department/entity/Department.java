package com.infynicode.department.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name = "departments")
@AllArgsConstructor // all argument constructors
@NoArgsConstructor// default constructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deptId;
    private String deptName;
    private String deptCode;
    private String description;
    private String deptHod;
    private Integer hospitalId;
}
