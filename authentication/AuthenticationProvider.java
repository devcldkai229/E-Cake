package devcldkai.kaipizzas.authentication;

import devcldkai.kaipizzas.exception.AuthenticationException;

public interface AuthenticationProvider {

    Authentication authenticate(Authentication authentication) throws AuthenticationException;

    boolean supports(Class<?> authentication);

}
