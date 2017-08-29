package com.kpyda.users.domain.users;


import com.kpyda.users.domain.users.dto.UserDetailsDTO;

class UserAssembler {

    static UserDetailsDTO toDTO(User user) {
        return UserDetailsDTO.builder()
                .userId(user.getId())
                .email(user.getUsername().getEmail())
                .username(user.getUsername().getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }
}
