package com.infynicode.department.service;


import com.infynicode.department.entity.Department;
import com.infynicode.department.exception.DepartmentException;
import com.infynicode.department.mapper.DepartmentDataMapper;
import com.infynicode.department.model.DepartmentMO;
import com.infynicode.department.repo.DepartmentRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepo departmentRepo;
    private final DepartmentDataMapper departmentDataMapper;
    private final ModelMapper modelMapper;

    public DepartmentMO saveDepartment(DepartmentMO input) {
        Department department= departmentDataMapper.convertModelToEntity(input);
        Department departmentCreated= departmentRepo.save(department);

        return  modelMapper.map(departmentCreated,DepartmentMO.class);
        //return departmentDataMapper.convertEntityToModel(departmentCreated);
    }

    public List<DepartmentMO> getAllDepartmentData() {
        List<Department> list=departmentRepo.findAll();
        return getDepartmentMOS(list);
    }



    public DepartmentMO getSingleDepartment(Integer departmentId) {
        Optional<Department> optionalHospital=  departmentRepo.findById(departmentId);
        if(!optionalHospital.isPresent()){
            throw new DepartmentException("No Department data found...");
        }
        return departmentDataMapper.convertEntityToModel(optionalHospital.get());
    }

    public List<DepartmentMO> getDepartments(Integer hospitalId) {
        List<Department> list=   departmentRepo.findByHospitalId(hospitalId);
        return getDepartmentMOS(list);

    }

    private List<DepartmentMO> getDepartmentMOS(List<Department> list) {
        List<DepartmentMO> response=new ArrayList<>();
        for (Department department: list) {
            response.add(departmentDataMapper.convertEntityToModel(department));
        }
        return response;
    }
}
