package devcldkai.kaipizzas.exception;

public class InternalAuthenticationServiceException extends AuthenticationServiceException {
    public InternalAuthenticationServiceException(String msg) {
        super(msg);
    }

    public InternalAuthenticationServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
