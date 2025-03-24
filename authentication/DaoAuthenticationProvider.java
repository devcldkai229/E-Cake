package devcldkai.kaipizzas.authentication;

import devcldkai.kaipizzas.exception.AuthenticationException;
import devcldkai.kaipizzas.exception.BadCredentialsException;
import devcldkai.kaipizzas.exception.InternalAuthenticationServiceException;
import devcldkai.kaipizzas.exception.UsernameNotFoundException;

public class DaoAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider{

    private UserDetailsService userDetailsService = new JdbcUserDetailsManager();

    private PasswordEncoder passwordEncoder = new BcryptPasswordEncoder();

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        if(authentication.getCredential() == null){
            throw new BadCredentialsException(
                    "Bad Credentials");
        }
        String presentedPassword = authentication.getCredential().toString();
        if(!this.passwordEncoder.matches(presentedPassword, userDetails.getPassword())){
            System.out.println("Password incorrect");
            throw new BadCredentialsException(
                    "Bad Credentials");
        }
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        try {
            UserDetails loadedUser = this.userDetailsService.loadUserByUsername(username);
            if (loadedUser == null) {
                throw new InternalAuthenticationServiceException(
                        "UserDetailsService returned null, which is an interface contract violation");
            }
            return loadedUser;
        } catch(UsernameNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (InternalAuthenticationServiceException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }
}
