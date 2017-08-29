package com.kpyda.users.domain.users;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(UserBinding.class)
public class UserConfiguration {

}
