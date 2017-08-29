package com.kpyda.security.account;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

interface AccountBinding {

    String DESTINATION = "usersCreatedEvent";

    @Input("usersCreatedEvent")
    SubscribableChannel usersCreatedEvent();
}
