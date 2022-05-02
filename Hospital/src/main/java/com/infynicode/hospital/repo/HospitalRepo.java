package com.infynicode.hospital.repo;

import com.infynicode.hospital.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepo extends JpaRepository<Hospital,Integer> {

    //1.save(entity)  --it is used for save and update as well
    // if primary key is not in request that time , jpa will is create request
    // if primary key coming in request that time , jpa will thing it is update operation.

    //findAll()-->List<Entity>-- gives all data from ur table.
    //findById(primaryKey)-->Optional<Entity>---> it gives matched data from table
}
