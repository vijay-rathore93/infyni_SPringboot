package com.infynicode.hospital.entity;


import com.infynicode.hospital.utility.HospitalConstant;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
@Entity
@Builder
@Table(name = "hospital")
@AllArgsConstructor // all argument constructors
@NoArgsConstructor// default constructor
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    @NotNull(message = HospitalConstant.NAME_REQUIRED)
    @NotBlank(message = HospitalConstant.NAME_REQUIRED)
    @Length(min = 4, max = 50, message = HospitalConstant.NAME_LENGTH)
    private String name;
    @NotNull(message = HospitalConstant.CODE_REQUIRED)
    @NotBlank(message = HospitalConstant.CODE_REQUIRED)
    @Length(min = 8, max = 8, message = HospitalConstant.CODE_LENGTH)
    private String code;  //Code must  be of length 8 Characters and first 4 must alphabets and rest 4 will be number
    @NotNull(message = HospitalConstant.STATE_REQUIRED)
    @NotBlank(message = HospitalConstant.STATE_REQUIRED)
    @Length(min = 4, max = 50, message = HospitalConstant.STATE_LENGTH)
    private String state;
    private String city;


    @NotNull(message = HospitalConstant.COUNTRY_REQUIRED)
    @NotBlank(message = HospitalConstant.COUNTRY_REQUIRED)
    private String country;   //Country can be only US/CANADA



    @NotNull(message = HospitalConstant.ZIP_REQUIRED)
    private Integer zipCode;
    private String addressLine1;
    private String addressLine2;
    private String streetName;

}
