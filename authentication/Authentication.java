package devcldkai.kaipizzas.authentication;

import java.util.Collection;

public interface Authentication {

    Collection<? extends GrantedAuthority> getAuthorities();

    String getPrincipal();

    String getCredential();

    boolean isAuthenticated();

    void setAuthenticated(boolean authenticated) throws IllegalArgumentException;

}
