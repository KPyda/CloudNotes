package com.kpyda.notes.domain.support;

import com.kpyda.notes.domain.support.dto.UserTokenDetails;
import org.springframework.stereotype.Component;

@Component
public class TokenService {
    public UserTokenDetails getDetailsFromToken() {
        return new UserTokenDetails("jpyda", "jpyda");
    }
}
