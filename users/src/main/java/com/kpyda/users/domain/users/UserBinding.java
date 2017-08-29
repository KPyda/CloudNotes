package com.kpyda.users.domain.users;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface UserBinding {

    String SOURCE = "usersCreated";
    String DESTINATION = "usersCreatedEvent";

    @Output("usersCreated")
    MessageChannel usersCreated();

    @Input("usersCreatedEvent")
    SubscribableChannel usersCreatedEvent();

}
