package com.infynicode.hospital.mapper;

import com.infynicode.hospital.entity.Hospital;
import com.infynicode.hospital.model.HospitalMO;
import org.springframework.stereotype.Component;


@Component
public class HospitalDataMapper {


    public Hospital convertModelToEntity(HospitalMO input ){
        Hospital hospital = new Hospital();
        hospital.setName(input.getName());
        hospital.setAddressLine1(input.getAddressLine1());
        hospital.setCity(input.getCity());
        hospital.setAddressLine2(input.getAddressLine2());
        hospital.setCode(input.getCode());
        hospital.setState(input.getState());
        hospital.setStreetName(input.getStreetName());
        hospital.setZipCode(input.getZipCode());
        hospital.setCountry(input.getCountry());
        return hospital;
    }


    public HospitalMO convertEntityToModel(Hospital input ){

       return HospitalMO.builder().addressLine1(input.getAddressLine1())
                .addressLine2(input.getAddressLine2())
                .city(input.getCity())
                .code(input.getCode())
                .zipCode(input.getZipCode())
                .name(input.getName())
                .state(input.getState())
                .country(input.getCountry())
                .streetName(input.getStreetName())
                .country(input.getCountry())
                .id(input.getId())
                .build();
    }
}
