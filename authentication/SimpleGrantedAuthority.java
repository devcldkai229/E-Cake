package devcldkai.kaipizzas.authentication;

import java.util.Objects;

public class SimpleGrantedAuthority implements GrantedAuthority {

    private final String role;

    public SimpleGrantedAuthority(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return this.role;
    }

    @Override
    public String toString() {
        return this.role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleGrantedAuthority that)) return false;
        return Objects.equals(role, that.role);
    }

}
