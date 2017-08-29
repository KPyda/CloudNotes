package com.kpyda.users.domain.users;

import com.kpyda.commons.annotations.DomainService;
import com.kpyda.users.domain.users.dto.UserDetailsDTO;
import com.kpyda.users.domain.users.dto.event.UserCreatedEvent;
import com.kpyda.users.domain.users.dto.request.CreateUserCommand;
import com.kpyda.users.domain.users.dto.response.CreatedUserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import static org.springframework.messaging.support.MessageBuilder.withPayload;

@DomainService
@RequiredArgsConstructor
@Slf4j
public class UserDomainService {

    private final UserRepository userRepository;
    private final UserBinding userBinding;

    public Mono<CreatedUserResponse> createUserCommand(CreateUserCommand command) {
        return userRepository.save(new User(command))
                .doOnNext(this::userCreatedEvent)
                .map(user -> new CreatedUserResponse(user.getId()));
    }

    private void userCreatedEvent(User user) {
        UserCreatedEvent payload = new UserCreatedEvent(user.getId(), user.getUsername().getUsername(), user.getPassword());
        log.info("{}", payload);
        userBinding.usersCreated().send(withPayload(payload).build());
    }

    public Mono<UserDetailsDTO> getUserDetails(String userId) {
        return userRepository.findById(userId)
                .map(UserAssembler::toDTO);
    }
}
