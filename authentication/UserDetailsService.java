package devcldkai.kaipizzas.authentication;

import devcldkai.kaipizzas.exception.UsernameNotFoundException;

public interface UserDetailsService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
