package com.kpyda.security.account;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

@Configuration
class AccountConfiguration {

    private static final String REGEX = ",";

    @Bean
    CommandLineRunner init(AccountRepository accountRepository) {
        accountRepository.deleteAll();
        return args -> {
            Stream.of("username,password")
                    .map(x -> x.split(REGEX))
                    .forEach(tpl -> accountRepository.save(new Account(tpl[0], tpl[1], true)));
            accountRepository.findAll().forEach(System.out::println);
        };
    }
}
