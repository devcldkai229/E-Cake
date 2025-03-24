package devcldkai.kaipizzas.authentication;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class BcryptPasswordEncoder implements PasswordEncoder{

    @Override
    public String encode(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return BCrypt.verifyer().verify(rawPassword.toCharArray(), encodedPassword).verified;
    }
}
