package devcldkai.kaipizzas.authentication;

import devcldkai.kaipizzas.exception.AuthenticationException;

import java.util.ArrayList;
import java.util.List;

public class ProviderManager implements AuthenticationManager {

    private List<AuthenticationProvider> providers = new ArrayList<>();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Class<? extends Authentication> toTest = authentication.getClass();
        Authentication result = null;
        for (AuthenticationProvider provider : providers) {
            if (!provider.supports(toTest)) {continue;}
            try {
                result = provider.authenticate(authentication);
                if(result != null) {return result;}
            } catch (AuthenticationException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public void addAuthenticationProvider(AuthenticationProvider authenticationProvider) {
        this.providers.add(authenticationProvider);
    }

    public List<AuthenticationProvider> getProviders() {
        return providers;
    }


}
