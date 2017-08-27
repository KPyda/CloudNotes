package com.kpyda.security.account;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
class Account {
    @Id
    private String id;
    private String username;
    private String password;
    private Boolean active;

    Account(String name, String password, Boolean active) {
        this.username = name;
        this.password = password;
        this.active = active;
    }
}
