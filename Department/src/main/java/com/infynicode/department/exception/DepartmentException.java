package com.infynicode.department.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DepartmentException extends RuntimeException{
    private String errorMessage;
}
