package com.kpyda.users.domain.users;

import com.kpyda.users.domain.users.dto.request.CreateUserCommand;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
class User {

    @Id
    private String id;
    private Username username;
    private String firstName;
    private String lastName;
    private String password;

    User(CreateUserCommand command) {
        id = UUID.randomUUID().toString();
        username = new Username(command.getUsername(), command.getEmail());
        firstName = command.getFirstName();
        lastName = command.getLastName();
        password = command.getPassword();
    }
}
