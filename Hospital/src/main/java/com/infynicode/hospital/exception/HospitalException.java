package com.infynicode.hospital.exception;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class HospitalException extends RuntimeException{
    private String errorMessage;
}
