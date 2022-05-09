package com.infynicode.department.exception;

import com.infynicode.department.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestControllerAdvice
public class GlobalHospitalException {

    @ExceptionHandler(DepartmentException.class)
    public ResponseEntity<ErrorResponse> handlingException(DepartmentException hospitalException){
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

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handler(ConstraintViolationException exception) {
        Map<String, String> errorMessage=new HashMap<>();
        Set<ConstraintViolation<?>> error= exception.getConstraintViolations();
        for (ConstraintViolation constraintViolation:error) {
            errorMessage.put(constraintViolation.getPropertyPath().toString(),constraintViolation.getMessage());
        }
        return new ResponseEntity<>(ErrorResponse.builder().errors(errorMessage).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handler(SQLIntegrityConstraintViolationException exception) {
        return new ResponseEntity<>(ErrorResponse.builder().errorMessage(exception.getLocalizedMessage()).build(), HttpStatus.BAD_REQUEST);
    }


}
