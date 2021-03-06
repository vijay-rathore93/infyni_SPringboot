package com.infynicode.department.service;

import com.infynicode.department.entity.Department;
import com.infynicode.department.exception.DepartmentException;
import com.infynicode.department.mapper.DepartmentDataMapper;
import com.infynicode.department.model.DepartmentMO;
import com.infynicode.department.repo.DepartmentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTests {

    @Mock
    private DepartmentRepo departmentRepo;
    @Mock
    private DepartmentDataMapper departmentDataMapper;

    @InjectMocks
    private DepartmentService departmentService;

    @Test
    public void saveDepartmentTest() {
        DepartmentMO request = getDepartmentMO();
        Department convertedRequest = getDepartment();
        Department response = getDepartment();
        response.setDeptId(1);
        DepartmentMO finalResponse = getDepartmentMO();
        finalResponse.setDeptId(1);
        when(departmentDataMapper.convertModelToEntity(request)).thenReturn(convertedRequest);
        when(departmentRepo.save(convertedRequest)).thenReturn(response);
        when(departmentDataMapper.convertEntityToModel(response)).thenReturn(finalResponse);
        DepartmentMO actualResponse = departmentService.saveDepartment(request);
        assertions(finalResponse, actualResponse);
        verify(departmentDataMapper, Mockito.times(1)).convertModelToEntity(request);
        verify(departmentRepo, Mockito.times(1)).save(convertedRequest);
        verify(departmentDataMapper, Mockito.times(1)).convertEntityToModel(response);
    }

    @Test
    public void getSingleDepartmentTestSuccess() {
        Department response = getDepartment();
        response.setDeptId(1);
        Optional<Department> departmentOptional = Optional.of(response);
        DepartmentMO finalResponse = getDepartmentMO();
        finalResponse.setDeptId(1);
        when(departmentRepo.findById(1)).thenReturn(departmentOptional);
        when(departmentDataMapper.convertEntityToModel(departmentOptional.get())).thenReturn(finalResponse);
        DepartmentMO actualResponse = departmentService.getSingleDepartment(1);
        assertions(finalResponse, actualResponse);
        verify(departmentRepo, Mockito.times(1)).findById(1);
        verify(departmentDataMapper, Mockito.times(1)).convertEntityToModel(departmentOptional.get());
    }



    @Test
    public void getSingleDepartmentTestNegative() {
        Optional<Department> departmentOptional = Optional.empty();
        when(departmentRepo.findById(1)).thenReturn(departmentOptional);
        DepartmentException exceptionResponse = Assertions.assertThrows(DepartmentException.class,
                () -> departmentService.getSingleDepartment(1));
        assertNotNull(exceptionResponse);
        assertNotNull(exceptionResponse.getErrorMessage());
        assertEquals("No Department data found...", exceptionResponse.getErrorMessage());
        verify(departmentRepo, Mockito.times(1)).findById(1);
    }

    @Test
    public void getDepartmentsTest() {
        Department department= getDepartment();
        department.setDeptId(1);
        List<Department> departments= Arrays.asList(department);
        when( departmentRepo.findByHospitalId(1)).thenReturn(departments);
        departments.forEach(obj->{
            DepartmentMO departmentMO= getDepartmentMO();
            departmentMO.setDeptId(1);
            when(departmentDataMapper.convertEntityToModel(obj)).thenReturn(departmentMO);
        });
        List<DepartmentMO>  actualResponse = departmentService.getDepartments(1);
        assertNotNull(actualResponse);
        assertEquals(1,actualResponse.size());
        assertEquals(1,actualResponse.get(0).getHospitalId());
        assertEquals(1,actualResponse.get(0).getDeptId());
        verify(departmentRepo, Mockito.times(1)).findByHospitalId(1);
    }


    private DepartmentMO getDepartmentMO() {
        return DepartmentMO.builder()
                .deptName("Test depart")
                .deptHod("Test HOD")
                .deptCode("Test Code")
                .description("Test Description")
                .hospitalId(1)
                .build();
    }

    private Department getDepartment() {
        return Department.builder()
                .deptName("Test depart")
                .deptHod("Test HOD")
                .deptCode("Test Code")
                .description("Test Description")
                .hospitalId(1)
                .build();
    }


    private void assertions(DepartmentMO finalResponse, DepartmentMO actualResponse) {
        assertNotNull(actualResponse);
        assertNotNull(actualResponse.getDeptId());
        assertEquals(finalResponse.getDeptName(), actualResponse.getDeptName());
        assertEquals(finalResponse.getDeptId(), actualResponse.getDeptId());
        assertEquals(finalResponse.getDeptHod(), actualResponse.getDeptHod());
        assertEquals(finalResponse.getDescription(), actualResponse.getDescription());
    }

}
