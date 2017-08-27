package com.kpyda.security.account;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
class AccountUserDetailsService implements UserDetailsService {

    private final AccountRepository accountRepository;

    AccountUserDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountRepository.findByUsername(username)
                .map(account -> {
                    log.info("Logging new user: {}", account.getUsername());
                    return new User(account.getUsername(),
                            account.getPassword(),
                            AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER"));
                })
                .orElseThrow(() -> new UsernameNotFoundException("oops! couldn't find " + username));
    }
}
