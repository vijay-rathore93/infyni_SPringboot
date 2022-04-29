package com.infynicode.hospital.entity;


import lombok.*;

import javax.persistence.*;


@Data
//@Getter @Setter @EqualAndHashCode
/*@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@ToString*/
@Entity
@Builder
@Table(name = "hospital")
@AllArgsConstructor // all argument constructors
@NoArgsConstructor// default constructor
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name",unique = true,length = 20,nullable = false)
    private String name;
    private String code;
    private String state;
    private String city;
    private String country;
    private Integer zipCode;
    private String addressLine1;
    private String addressLine2;
    private String streetName;

}
