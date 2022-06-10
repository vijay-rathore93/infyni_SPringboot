package com.infynicode.department.entity;

import com.infynicode.department.utility.DepartmentConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@Entity
@Builder
@Table(name = "departments")
@AllArgsConstructor // all argument constructors
@NoArgsConstructor// default constructor
public class Department  extends  Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deptId;

    @NotNull(message = DepartmentConstants.NAME_REQUIRED)
    @NotBlank(message = DepartmentConstants.NAME_REQUIRED)
    @Length(min=4, max=50, message=DepartmentConstants.NAME_LENGTH)
    private String deptName;

    @NotNull(message = DepartmentConstants.CODE_REQUIRED)
    @NotBlank(message = DepartmentConstants.CODE_REQUIRED)
    @Length(min=4, max=50, message = DepartmentConstants.CODE_LENGTH)
    private String deptCode;

    @NotNull(message = DepartmentConstants.DESCRIPTION_REQUIRED)
    @NotBlank(message = DepartmentConstants.DESCRIPTION_REQUIRED)
    @Length(min=0, max=255, message = DepartmentConstants.DESCRIPTION_LENGTH)
    private String description;

    @NotNull(message = DepartmentConstants.DEPT_HOD_REQUIRED)
    @NotBlank(message = DepartmentConstants.DEPT_HOD_REQUIRED)
    private String deptHod;

    @NotNull(message = DepartmentConstants.HOSPITAL_ID_REQUIRED)
    private Integer hospitalId;
}
