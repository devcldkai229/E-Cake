package devcldkai.kaipizzas.authentication;

import java.util.*;

public class User implements UserDetails{

    private final String username;

    private String password;

    private final Set<GrantedAuthority> authorities;

    private final boolean accountNonExpired;

    private final boolean accountNonLocked;

    private final boolean credentialsNonExpired;

    private final boolean enabled;

    public User(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this(username, password, true, true, true, true, authorities);
    }

    public User(String username, String password, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = Collections.unmodifiableSet(new HashSet<>(authorities));
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User user) {
            return this.username.equals(user.getUsername());
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName()).append(" [");
        sb.append("Username=").append(this.username).append(", ");
        sb.append("Password=[PROTECTED], ");
        sb.append("Enabled=").append(this.enabled).append(", ");
        sb.append("AccountNonExpired=").append(this.accountNonExpired).append(", ");
        sb.append("CredentialsNonExpired=").append(this.credentialsNonExpired).append(", ");
        sb.append("AccountNonLocked=").append(this.accountNonLocked).append(", ");
        sb.append("Granted Authorities=").append(this.authorities).append("]");
        return sb.toString();
    }






}
