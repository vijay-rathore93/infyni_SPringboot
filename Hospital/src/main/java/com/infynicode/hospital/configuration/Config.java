package com.infynicode.hospital.configuration;

import com.infynicode.hospital.service.HospitalService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "aware")
public class Config {

    /*@Bean
    public HospitalDataMapper hospitalDataMapper(){
        return new HospitalDataMapper();
    }*/


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public AuditorAware<String> aware() {
        return () -> Optional.of("Administrator");
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
