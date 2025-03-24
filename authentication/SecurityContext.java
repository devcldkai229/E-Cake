package devcldkai.kaipizzas.authentication;


public class SecurityContext {
    private Authentication authentication;

    public Authentication getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }

    public boolean isAuthenticated() {
        return authentication != null && authentication.isAuthenticated();
    }
}
