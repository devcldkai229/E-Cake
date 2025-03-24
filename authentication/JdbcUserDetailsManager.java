package devcldkai.kaipizzas.authentication;

import devcldkai.kaipizzas.domain.entities.Accounts;
import devcldkai.kaipizzas.exception.UserHasNotRoleException;
import devcldkai.kaipizzas.exception.UsernameNotFoundException;
import devcldkai.kaipizzas.service.impl.AccountsService;
import devcldkai.kaipizzas.service.impl.RoleService;

import java.util.HashSet;
import java.util.Set;

public class JdbcUserDetailsManager implements UserDetailsService {

    public static UserDetailsService getInstance(){
        return new JdbcUserDetailsManager();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Accounts dbAccounts = AccountsService.getInstance().getByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("Account not exists!")
        );
        String dbRole = RoleService.getInstance().getRole(dbAccounts.getRoleId()).orElseThrow(
                () -> new UserHasNotRoleException("Account not contain role")
        );
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(dbRole));

        return new User(dbAccounts.getUsername(), dbAccounts.getPassword(), authorities);
    }
}
