package com.kpyda.users.domain.users;

import com.kpyda.users.domain.users.dto.event.UserCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserEventHandler {

    @ServiceActivator(inputChannel = UserBinding.DESTINATION)
    public void loggerSink(UserCreatedEvent payload) {
        log.info("Received: {}", payload);
    }

}
