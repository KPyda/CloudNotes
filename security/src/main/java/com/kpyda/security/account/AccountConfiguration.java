package com.kpyda.security.account;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(AccountBinding.class)
class AccountConfiguration {
}
