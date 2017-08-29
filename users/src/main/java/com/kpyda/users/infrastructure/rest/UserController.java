package com.kpyda.users.infrastructure.rest;

import com.kpyda.users.domain.users.UserDomainService;
import com.kpyda.users.domain.users.dto.UserDetailsDTO;
import com.kpyda.users.domain.users.dto.request.CreateUserCommand;
import com.kpyda.users.domain.users.dto.response.CreatedUserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserDomainService userDomainService;

    @PostMapping(value = "/users")
    Mono<CreatedUserResponse> createUserCommand(@RequestBody CreateUserCommand command) {
        log.info("{}", command);
        return userDomainService.createUserCommand(command)
                .doOnNext(createdUserResponse -> log.info("{}", createdUserResponse));
    }

    @GetMapping("/users/{userId}")
    Mono<UserDetailsDTO> getUserQuery(@PathVariable String userId) {
        log.info("Get user by id: {}", userId);
        return userDomainService.getUserDetails(userId)
                .doOnNext(userDetailsDTO -> log.info("{}", userDetailsDTO));
    }
}
