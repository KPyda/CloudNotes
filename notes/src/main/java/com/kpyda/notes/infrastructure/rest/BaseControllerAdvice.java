package com.kpyda.notes.infrastructure.rest;

import com.kpyda.notes.infrastructure.exceptions.ApiErrorResponse;
import com.kpyda.notes.infrastructure.exceptions.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class BaseControllerAdvice {

    @ExceptionHandler(value = {ApiException.class})
    public ResponseEntity<ApiErrorResponse> handleException(ApiException exception) {
        log.info("{}", exception);
        return new ResponseEntity<>(new ApiErrorResponse(exception), exception.getHttpStatus());
    }

}
