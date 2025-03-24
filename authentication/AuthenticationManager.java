package devcldkai.kaipizzas.authentication;

import devcldkai.kaipizzas.exception.AuthenticationException;

public interface AuthenticationManager {
    Authentication authenticate(Authentication authentication) throws AuthenticationException;

    void addAuthenticationProvider(AuthenticationProvider authenticationProvider);

}
