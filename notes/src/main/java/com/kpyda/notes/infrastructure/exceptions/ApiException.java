package com.kpyda.notes.infrastructure.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ApiException extends RuntimeException {
    private String trace;
    private ApiStatus status;
    private String message;
    private Object data;

    @JsonIgnore
    private HttpStatus httpStatus;
}
