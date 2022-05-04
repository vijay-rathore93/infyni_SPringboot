package com.infynicode.hospital.configuration;

import com.infynicode.hospital.service.HospitalService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    /*@Bean
    public HospitalDataMapper hospitalDataMapper(){
        return new HospitalDataMapper();
    }*/


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }



}
