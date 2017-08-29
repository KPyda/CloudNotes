package com.kpyda.users.domain.users.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CreateUserCommand {
    String username;
    String email;
    String firstName;
    String lastName;
    String password;
}
