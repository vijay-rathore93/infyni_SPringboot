package com.infynicode.hospital.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include. NON_NULL)
public class ErrorResponse {
    private String errorMessage;
    private Map<String,String> errors;
}
