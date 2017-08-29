package com.kpyda.users.domain.users.dto.event;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserCreatedEvent {
    String userId;
    String username;
    String password;
}
