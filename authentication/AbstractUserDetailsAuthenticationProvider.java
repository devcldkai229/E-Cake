package devcldkai.kaipizzas.authentication;

import devcldkai.kaipizzas.exception.AuthenticationException;
import devcldkai.kaipizzas.exception.UsernameNotFoundException;

public abstract class AbstractUserDetailsAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = determineUsername(authentication);
        UserDetails user = null;
        try {
            user = retrieveUser(username, (UsernamePasswordAuthenticationToken) authentication);
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
            return createFailedAuthentication(username, authentication, user);
        }
        try {
            additionalAuthenticationChecks(user, (UsernamePasswordAuthenticationToken) authentication);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return createFailedAuthentication(username, authentication, user);
        }
        return createSuccessAuthentication(username, authentication, user);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

    protected abstract void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException;

    private String determineUsername(Authentication authentication){
        return authentication.getPrincipal() == null ? "NONE_PROVIDED" : authentication.getPrincipal().toString();
    }

    protected abstract UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
            throws AuthenticationException;

    private Authentication createSuccessAuthentication(String principal, Authentication authentication, UserDetails user){
        UsernamePasswordAuthenticationToken result = UsernamePasswordAuthenticationToken
                .authenticated(principal, authentication.getCredential(), user.getAuthorities());

        return result;
    }

    private Authentication createFailedAuthentication(String principal, Authentication authentication, UserDetails user){
        UsernamePasswordAuthenticationToken result = UsernamePasswordAuthenticationToken
                .unauthenticated(principal, authentication.getCredential());

        return result;
    }

}
