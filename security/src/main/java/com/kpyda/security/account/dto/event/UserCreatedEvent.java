package com.kpyda.security.account.dto.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(exclude = "password")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserCreatedEvent {
    String userId;
    String username;
    String password;
}
