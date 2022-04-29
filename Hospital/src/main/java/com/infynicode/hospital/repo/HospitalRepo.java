package com.infynicode.hospital.repo;

import com.infynicode.hospital.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepo extends JpaRepository<Hospital,Integer> {
}
