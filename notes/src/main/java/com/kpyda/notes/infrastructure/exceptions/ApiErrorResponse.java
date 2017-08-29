package com.kpyda.notes.infrastructure.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ApiErrorResponse {
    private String trace;
    private ApiStatus status;
    @JsonInclude(NON_NULL)
    private String message;
    @JsonInclude(NON_NULL)
    private Object data;

    public ApiErrorResponse(ApiException exception) {
        this.trace = exception.getTrace();
        this.status = exception.getStatus();
        this.message = exception.getMessage();
        this.data = exception.getData();
    }
}
