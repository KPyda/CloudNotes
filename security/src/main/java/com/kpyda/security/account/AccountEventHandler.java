package com.kpyda.security.account;

import com.kpyda.security.account.dto.event.UserCreatedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
class AccountEventHandler {

    private final AccountRepository accountRepository;

    @ServiceActivator(inputChannel = AccountBinding.DESTINATION)
    public void loggerSink(UserCreatedEvent event) {
        log.info("Received: {}", event);
        Account entity = new Account(event.getUsername(), event.getPassword(), true, event.getUserId());
        accountRepository.save(entity);
    }
}
