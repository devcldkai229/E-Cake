package devcldkai.kaipizzas.exception;

public class AuthenticationServiceException extends AuthenticationException {

    public AuthenticationServiceException(String msg) {
        super(msg);
    }

    public AuthenticationServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
