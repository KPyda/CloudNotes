package com.kpyda.security.account;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

interface AccountRepository extends MongoRepository<Account, String> {
    Optional<Account> findByUsername(String username);
}
