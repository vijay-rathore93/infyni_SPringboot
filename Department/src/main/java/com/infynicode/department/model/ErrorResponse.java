package com.infynicode.department.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
public class ErrorResponse {
    private String errorMessage;
    private Map<String,String> errors;
}
