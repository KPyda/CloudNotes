package com.kpyda.notes.domain.support.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserTokenDetails {
    private String userId;
    private String username;
}
