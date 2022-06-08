package com.infynicode.hospital.service;


import com.infynicode.hospital.entity.Hospital;
import com.infynicode.hospital.mapper.HospitalDataMapper;
import com.infynicode.hospital.model.DepartmentMO;
import com.infynicode.hospital.model.HospitalMO;
import com.infynicode.hospital.repo.HospitalRepo;
import com.infynicode.hospital.utility.Validators;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
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
    private Validators validators;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private HospitalService hospitalService;

    @Mock
    private  ModelMapper modelMapper;




    @Test
    public void getAllHospitalsTests(){
        String departmentBaseUrl="TestURL";
        ReflectionTestUtils.setField(hospitalService,"departmentBaseUrl",departmentBaseUrl);
        Hospital hospital= getHospital();
        hospital.setId(1);
        List<Hospital> hospitals= Arrays.asList(hospital);
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Mockito.when(hospitalRepo.findAll(sort)).thenReturn(hospitals);
        hospitals.forEach(obj->{
            HospitalMO hospitalMO= getHospitalMO();
            hospitalMO.setId(1);
            Mockito.when(hospitalDataMapper.convertEntityToModel(obj)).thenReturn(hospitalMO);
            Mockito.when( restTemplate.exchange(departmentBaseUrl +"/hospital/"+ 1,
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<DepartmentMO>>(){}))
                    .thenReturn(new ResponseEntity<>(Arrays.asList(getDepartmentMO()), HttpStatus.OK))   ;     });
        List<HospitalMO> actualResponse=  hospitalService.getAllHospitals("id","desc");
        assertNotNull(actualResponse);
        assertEquals(1,actualResponse.size());
        assertEquals(1,actualResponse.get(0).getId());

        verify(hospitalRepo, Mockito.times(1)).findAll(sort);
    }


    @Test
    public void createHospitalRecordTest(){
        HospitalMO hospitalMO= getHospitalMO();
        HospitalMO convertedMO= getHospitalMO();
        convertedMO.setId(1);
        Hospital hospital=getHospital();
        Hospital hospital1=getHospital();
        hospital1.setId(1);
        Mockito.doNothing().when(validators).validateRequest(hospitalMO);
        Mockito.when(hospitalDataMapper.convertModelToEntity(hospitalMO)).thenReturn(hospital);
        Mockito.when( hospitalRepo.save(hospital)).thenReturn(hospital1);
        Mockito.when( modelMapper.map(hospital1,HospitalMO.class)).thenReturn(convertedMO);
        HospitalMO response= hospitalService.createHospitalRecord(hospitalMO);
        assertNotNull(response);
        assertEquals(1,response.getId());
        verify(validators, Mockito.times(1)).validateRequest(hospitalMO);
        verify(hospitalDataMapper, Mockito.times(1)).convertModelToEntity(hospitalMO);
        verify(hospitalRepo, Mockito.times(1)).save(hospital);
        verify(modelMapper, Mockito.times(1)).map(hospital1,HospitalMO.class);

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


    private DepartmentMO getDepartmentMO() {
        return DepartmentMO.builder()
                .deptName("Test depart")
                .deptHod("Test HOD")
                .deptCode("Test Code")
                .description("Test Description")
                .build();
    }


}
