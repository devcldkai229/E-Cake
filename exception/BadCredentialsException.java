package devcldkai.kaipizzas.exception;

public class BadCredentialsException extends AuthenticationException{

    public BadCredentialsException(String msg) {
        super(msg);
    }

    public BadCredentialsException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
