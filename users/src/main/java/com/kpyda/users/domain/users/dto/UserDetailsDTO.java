package com.kpyda.users.domain.users.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class UserDetailsDTO {
    private String userId;
    private String email;
    private String username;
    private String firstName;
    private String lastName;
}
