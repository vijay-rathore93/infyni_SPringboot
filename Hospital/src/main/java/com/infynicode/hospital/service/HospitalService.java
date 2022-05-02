package com.infynicode.hospital.service;

import com.infynicode.hospital.entity.Hospital;
import com.infynicode.hospital.exception.HospitalException;
import com.infynicode.hospital.mapper.HospitalDataMapper;
import com.infynicode.hospital.model.HospitalMO;
import com.infynicode.hospital.repo.HospitalRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.patterns.HasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepo hospitalRepo;

    private final HospitalDataMapper hospitalDataMapper;


    public HospitalMO createHospitalRecord(HospitalMO input) {
        //conversion of Model to entity as we are saving in DB(Service->repo)
        Hospital hospital=hospitalDataMapper.convertModelToEntity(input);
        Hospital hospitalCreated = hospitalRepo.save(hospital);
        //conversion of entity to Model as we are sending response(Service->Controller)
        return hospitalDataMapper.convertEntityToModel(hospitalCreated);
    }

    public List<HospitalMO> getAllHospitals() {
        List<Hospital>  hospitals= hospitalRepo.findAll();
        List<HospitalMO> response=new ArrayList<>();
        for (Hospital hospital:hospitals) {
            response.add(hospitalDataMapper.convertEntityToModel(hospital));
        }
        return  response;
    }

    public HospitalMO getSingleHospital(Integer hospitalId) {
        Optional<Hospital> optionalHospital=  hospitalRepo.findById(hospitalId);
        if(!optionalHospital.isPresent()){
            throw new HospitalException("No Hospital data found...");
        }
        return hospitalDataMapper.convertEntityToModel(optionalHospital.get());
    }












}
