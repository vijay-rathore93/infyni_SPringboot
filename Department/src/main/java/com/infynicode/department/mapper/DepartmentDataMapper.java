/*package com.infynicode.department.mapper;


import com.infynicode.department.entity.Department;
import com.infynicode.department.model.DepartmentMO;
import org.springframework.stereotype.Component;

import java.util.UUID;



@Component
public class DepartmentDataMapper {

    public Department convertModelToEntity(DepartmentMO input ){
        return Department.builder()
                .deptId(input.getDeptId())
                .description(input.getDescription())
                .deptName(input.getDeptName())
                .deptHod(input.getDeptHod())
                .deptCode(input.getDeptName()+ UUID.randomUUID().toString())
                .hospitalId(input.getHospitalId())
                .build();
    }


    public DepartmentMO convertEntityToModel(Department input ){
        return DepartmentMO.builder()
                .deptId(input.getDeptId())
                .description(input.getDescription())
                .deptName(input.getDeptName())
                .deptHod(input.getDeptHod())
                .deptCode(input.getDeptCode())
                .hospitalId(input.getHospitalId())
                .build();
    }
}
*/