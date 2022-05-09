package com.infynicode.department.repo;

import com.infynicode.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {
    List<Department> findByHospitalId(Integer hospitalId);
}
