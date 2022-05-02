package com.infynicode.hospital.exception;


import com.infynicode.hospital.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHospitalException {

    @ExceptionHandler(HospitalException.class)
    public ResponseEntity<ErrorResponse> handlingException(HospitalException hospitalException){
        return new ResponseEntity(ErrorResponse
                .builder()
                .errorMessage(hospitalException.getErrorMessage())
                .build(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handlingException(Exception exception){
        return new ResponseEntity(ErrorResponse
                .builder()
                .errorMessage(exception.getMessage())
                .build(),
                HttpStatus.BAD_REQUEST);
    }


}
