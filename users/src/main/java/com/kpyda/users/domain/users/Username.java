package com.kpyda.users.domain.users;

import lombok.Value;
import org.hibernate.validator.constraints.NotEmpty;

@Value
class Username {
    @NotEmpty
    private String username;
    @NotEmpty
    private String email;
}