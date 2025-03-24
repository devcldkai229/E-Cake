package devcldkai.kaipizzas.authentication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class AbstractAuthenticationToken implements Authentication {

    private final List<GrantedAuthority> authorities;

    private boolean authenticated = false;

    public AbstractAuthenticationToken(Collection<? extends GrantedAuthority> authorities) {
        if(authorities == null || authorities.isEmpty()){
            this.authorities = new ArrayList<GrantedAuthority>();
            return;
        }
        this.authorities = Collections.unmodifiableList(new ArrayList<>(authorities));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public boolean isAuthenticated() {
        return this.authenticated;
    }

    @Override
    public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
        this.authenticated = authenticated;
    }
}
