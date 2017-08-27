package com.kpyda.security;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
class PrincipalRestController {

    @GetMapping("/user")
    Principal principal(Principal p) {
        return p;
    }
}
