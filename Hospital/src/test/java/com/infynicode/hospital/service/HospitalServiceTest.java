package com.infynicode.hospital.service;


import com.infynicode.hospital.entity.Hospital;
import com.infynicode.hospital.mapper.HospitalDataMapper;
import com.infynicode.hospital.model.HospitalMO;
import com.infynicode.hospital.repo.HospitalRepo;
import com.infynicode.hospital.utility.Validators;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class HospitalServiceTest {

    @Mock
    private HospitalRepo hospitalRepo;
    @Mock
    private HospitalDataMapper hospitalDataMapper;
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private Validators validators;

    @InjectMocks
    private HospitalService hospitalService;


    @Test
    public void getAllHospitalsTests(){
        Hospital hospital= getHospital();
        hospital.setId(1);
        List<Hospital> hospitals= Arrays.asList(hospital);
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Mockito.when(hospitalRepo.findAll(sort)).thenReturn(hospitals);
        hospitals.forEach(obj->{
            HospitalMO hospitalMO= getHospitalMO();
            hospitalMO.setId(1);
            Mockito.when(hospitalDataMapper.convertEntityToModel(obj)).thenReturn(hospitalMO);
        });
        List<HospitalMO> actualResponse=  hospitalService.getAllHospitals("id","desc");
        assertNotNull(actualResponse);
        assertEquals(1,actualResponse.size());
        assertEquals(1,actualResponse.get(0).getId());

        verify(hospitalRepo, Mockito.times(1)).findAll(sort);
    }


    private Hospital getHospital(){
        return Hospital.builder()
                .name("Test Hospital")
                .code("XYZ12345")
                .country("India")
                .state("KA")
                .city("Bangalore")
                .zipCode(560102)
                .addressLine1("HSR")
                .build();

    }


    private HospitalMO getHospitalMO(){
        return HospitalMO.builder()
                .name("Test Hospital")
                .code("XYZ12345")
                .country("India")
                .state("KA")
                .city("Bangalore")
                .zipCode(560102)
                .addressLine1("HSR")
                .build();

    }



}
