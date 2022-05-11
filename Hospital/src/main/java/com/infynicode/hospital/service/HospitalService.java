package com.infynicode.hospital.service;

import com.infynicode.hospital.entity.Hospital;
import com.infynicode.hospital.exception.HospitalException;
import com.infynicode.hospital.mapper.HospitalDataMapper;
import com.infynicode.hospital.model.DepartmentMO;
import com.infynicode.hospital.model.HospitalMO;
import com.infynicode.hospital.repo.HospitalRepo;
import com.infynicode.hospital.utility.Validators;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepo hospitalRepo;

    private final HospitalDataMapper hospitalDataMapper;

    private final RestTemplate restTemplate;

    private final Validators validators;

    private final ModelMapper modelMapper;

    @Value("${department.base.url}")
    private String departmentBaseUrl;


    public HospitalMO createHospitalRecord(HospitalMO input) {
        //conversion of Model to entity as we are saving in DB(Service->repo)

        validators.validateRequest(input);

        Hospital hospital = hospitalDataMapper.convertModelToEntity(input);
        Hospital hospitalCreated = hospitalRepo.save(hospital);
        //conversion of entity to Model as we are sending response(Service->Controller)

        //with model mapper.
       return  modelMapper.map(hospitalCreated,HospitalMO.class);

       //with data mapper (manually)
       // return hospitalDataMapper.convertEntityToModel(hospitalCreated);
    }

    public List<HospitalMO> getAllHospitals(String criteria,String sortingType) {
        Sort.Direction direction= sortingType.equalsIgnoreCase("desc")?Sort.Direction.DESC:Sort.Direction.ASC;
        Sort sort = Sort.by(direction, criteria);
        List<Hospital> hospitals = hospitalRepo.findAll(sort);
        List<HospitalMO> response = new ArrayList<>();
        for (Hospital hospital:hospitals) {
            HospitalMO hospitalMO= hospitalDataMapper.convertEntityToModel(hospital);
            getDepartments(hospitalMO.getId(), hospitalMO);
            response.add(hospitalMO);
        }
        return response;
    }

    public HospitalMO getSingleHospital(Integer hospitalId) {
        Optional<Hospital> optionalHospital = hospitalRepo.findById(hospitalId);
        if (!optionalHospital.isPresent()) {
            throw new HospitalException("No Hospital data found...");
        }
        HospitalMO hospitalMO= hospitalDataMapper.convertEntityToModel(optionalHospital.get());
        //calling department service to fetch corresponding department for particular hospital.
        getDepartments(hospitalId, hospitalMO);
        return hospitalMO;
    }

    private void getDepartments(Integer hospitalId, HospitalMO hospitalMO) {
        ResponseEntity<List<DepartmentMO>> responseEntity = restTemplate.exchange(departmentBaseUrl +"/hospital/"+ hospitalId,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<DepartmentMO>>(){});
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            List<DepartmentMO> departments=  responseEntity.getBody();
            hospitalMO.setDepartments(departments);
            //get data and set in response
        }else{
            log.info("No Departments are available for hospital id:{}", hospitalId);
        }
    }


}
